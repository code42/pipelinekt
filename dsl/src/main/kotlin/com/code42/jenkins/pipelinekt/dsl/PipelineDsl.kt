package com.code42.jenkins.pipelinekt.dsl

import com.code42.jenkins.pipelinekt.core.Agent
import com.code42.jenkins.pipelinekt.core.Environment
import com.code42.jenkins.pipelinekt.core.Option
import com.code42.jenkins.pipelinekt.core.Pipeline
import com.code42.jenkins.pipelinekt.core.Post
import com.code42.jenkins.pipelinekt.core.StageOption
import com.code42.jenkins.pipelinekt.core.stage.Stage
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.writer.ext.toStep
import com.code42.jenkins.pipelinekt.dsl.method.MethodDsl
import com.code42.jenkins.pipelinekt.dsl.method.PipelineMethodRegistry
import com.code42.jenkins.pipelinekt.dsl.option.ansiColor
import com.code42.jenkins.pipelinekt.dsl.option.buildDiscarder
import com.code42.jenkins.pipelinekt.dsl.option.disableConcurrentBuilds
import com.code42.jenkins.pipelinekt.dsl.option.logRotator
import com.code42.jenkins.pipelinekt.dsl.option.timestamps
import com.code42.jenkins.pipelinekt.dsl.post.PostContext
import com.code42.jenkins.pipelinekt.dsl.stage.MatrixContext
import com.code42.jenkins.pipelinekt.dsl.stage.NestedStageContext
import com.code42.jenkins.pipelinekt.dsl.stage.StageWrapperContext
import com.code42.jenkins.pipelinekt.dsl.stage.TopLevelStageContext
import com.code42.jenkins.pipelinekt.dsl.step.declarative.cleanWs
import java.util.Deque
import java.util.concurrent.LinkedBlockingDeque

fun <T, Dsl : MethodDsl> Dsl.withConfigurationContext(applyConfiguration: Dsl.() -> Dsl, stage: Dsl.() -> T): T {
    val windowsDsl = applyConfiguration()

    val result = windowsDsl.stage()

    windowsDsl.pipelineMethodRegistry.methods().forEach { method -> this.pipelineMethodRegistry.registerMethod(method) }
    return result
}

data class PipelineDsl(
    val defaultEnvironment: DslContext<Environment>.() -> Unit = {},
    val defaultBuildOptions: DslContext<Option>.() -> Unit = {
        buildDiscarder(logRotator(10, 10, 10, 10))
        ansiColor("xterm")
        timestamps()
        disableConcurrentBuilds()
    },
    val beforePrepSteps: DslContext<Step>.() -> Unit = { },
    val afterPrepSteps: DslContext<Step>.() -> Unit = { },
    val beforeLocalStage: DslContext<Step>.() -> Unit = { },
    val afterLocalStage: DslContext<Step>.() -> Unit = { },
    val beforeRemoteStage: DslContext<Step>.() -> Unit = { },
    val afterRemoteStage: DslContext<Step>.() -> Unit = { },
    val beforePipelinePost: PostContext.() -> Unit = { },
    val afterPipelinePost: PostContext.() -> Unit = {
        cleanup {
            cleanWs()
        }
    },
    val beforeLocalStagePost: PostContext.() -> Unit = { },
    val afterLocalStagePost: PostContext.() -> Unit = { },
    val beforeRemoteStagePost: PostContext.() -> Unit = { },
    val afterRemoteStagePost: PostContext.() -> Unit = {
        cleanup {
            cleanWs()
        }
    },
    val remoteStageOptions: DslContext<StageOption>.() -> Unit = { },
    val defaultAgent: SingletonDslContext<Agent>.() -> Unit = { },
    override val pipelineMethodRegistry: PipelineMethodRegistry = PipelineMethodRegistry(),
    val stages: Deque<Stage> = LinkedBlockingDeque()
) : MethodDsl {

    fun DslContext<Environment>.defaultEnvirontment() {
        defaultEnvironment.invoke(this)
    }

    fun DslContext<Option>.defaultBuildOptions() {
        defaultBuildOptions.invoke(this)
    }

    fun DslContext<Step>.beforePrepSteps() {
        beforePrepSteps.invoke(this)
    }

    fun DslContext<Step>.afterPrepSteps() {
        afterPrepSteps.invoke(this)
    }

    fun PostContext.beforePipelinePost() {
        beforePipelinePost.invoke(this)
    }

    fun PostContext.afterPipelinePost() {
        afterPipelinePost.invoke(this)
    }

    fun pipeline(
        prepSteps: DslContext<Step>.() -> Unit = { },
        pipelineBlock: PipelineContext.() -> Unit
    ): Pipeline {
        val context = PipelineContext(
            topLevelStageContext = topLevelStageWrapperContext(),
            pipelineMethodRegistry = pipelineMethodRegistry
        )
        context.pipelineBlock()

        val pipeline = Pipeline(
            environment = applyDefaultEnvironment(context.environmentContext.drainAll()),
            agent = context.agentContext.drainAll().firstOrNull() ?: SingletonDslContext.into(defaultAgent),
            tools = context.toolContext.drainAll(),
            parameters = context.parametersContext.drainAll(),
            options = applyDefaultPipelineOptions(context.optionContext.drainAll()),
            triggers = context.triggersContext.drainAll(),
            stages = prepStage(prepSteps) + context.topLevelStageContext.drainAll(),
            post = applyBeforeAndAfterPipelinePost(context.postContext.toPost()),
            methods = pipelineMethodRegistry.methods()
        )
        pipelineMethodRegistry.reset()
        return pipeline
    }

    private fun topLevelStageWrapperContext(): StageWrapperContext<TopLevelStageContext> =
        StageWrapperContext(
            pipelineMethodRegistry,
            beforeLocalStage,
            afterLocalStage,
            beforeRemoteStage,
            afterRemoteStage,
            beforeLocalStagePost,
            afterLocalStagePost,
            beforeRemoteStagePost,
            afterRemoteStagePost,
            remoteStageOptions,
            defaultAgent,
            {
                TopLevelStageContext(
                    parallelStageContext = nestedStageWrapperContext(),
                    nestedStageContext = nestedStageWrapperContext(),
                    matrixContext = MatrixContext(nestedStageWrapperContext())
                )
            },
            LinkedBlockingDeque()
        )

    private fun nestedStageWrapperContext(): StageWrapperContext<NestedStageContext> = StageWrapperContext(
        pipelineMethodRegistry,
        beforeLocalStage,
        afterLocalStage,
        beforeRemoteStage,
        afterRemoteStage,
        beforeLocalStagePost,
        afterLocalStagePost,
        beforeRemoteStagePost,
        afterRemoteStagePost,
        remoteStageOptions,
        defaultAgent,
        { NestedStageContext(nestedStageContext = nestedStageWrapperContext()) },
        LinkedBlockingDeque()
    )

    private fun prepStage(stepsBlock: DslContext<Step>.() -> Unit): List<Stage> {

        val prepSteps = DslContext.into<Step> {
            beforePrepSteps()
            stepsBlock()
            afterPrepSteps()
        }

        if (!prepSteps.isEmpty()) {
            return topLevelStageWrapperContext()
                .into {
                    stage("Prep") {
                        steps {
                            add(prepSteps.toStep())
                        }
                    }
                }
        } else {
            return emptyList()
        }
    }

    private fun applyBeforeAndAfterPipelinePost(post: Post): Post {
        val beforePostContext = PostContext()
        beforePostContext.beforePipelinePost()
        val beforePost = beforePostContext.toPost()

        val afterPostContext = PostContext()
        afterPostContext.afterPipelinePost()
        val afterPost = afterPostContext.toPost()

        return beforePost.merge(post).merge(afterPost)
    }

    private fun applyDefaultEnvironment(environment: List<Environment>): List<Environment> {
        val defaultEnvironment = DslContext
            .into<Environment> { defaultEnvirontment() }
            .filter { defaultEnvironment -> environment.none { it.javaClass == defaultEnvironment.javaClass } }
        return defaultEnvironment + environment
    }

    private fun applyDefaultPipelineOptions(options: List<Option>): List<Option> {
        val defaultOptions = DslContext
            .into<Option> { defaultBuildOptions() }
            .filter { defaultOption -> options.none { it.javaClass == defaultOption.javaClass } }
        return defaultOptions + options
    }
}
