package com.code42.jenkins.pipelinekt.dsl.stage

import com.code42.jenkins.pipelinekt.core.Agent
import com.code42.jenkins.pipelinekt.core.Post
import com.code42.jenkins.pipelinekt.core.StageOption
import com.code42.jenkins.pipelinekt.core.stage.Stage
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.writer.ext.toStep
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.dsl.SingletonDslContext
import com.code42.jenkins.pipelinekt.dsl.method.MethodDsl
import com.code42.jenkins.pipelinekt.dsl.method.PipelineMethodRegistry
import com.code42.jenkins.pipelinekt.dsl.post.PostContext
import java.util.Deque
import java.util.concurrent.LinkedBlockingDeque

data class StageWrapperContext<I : StageContext>(
    override val pipelineMethodRegistry: PipelineMethodRegistry,
    val beforeLocalStage: DslContext<Step>.() -> Unit,
    val afterLocalStage: DslContext<Step>.() -> Unit,
    val beforeRemoteStage: DslContext<Step>.() -> Unit,
    val afterRemoteStage: DslContext<Step>.() -> Unit,
    val beforeLocalStagePost: PostContext.() -> Unit,
    val afterLocalStagePost: PostContext.() -> Unit,
    val beforeRemoteStagePost: PostContext.() -> Unit,
    val afterRemoteStagePost: PostContext.() -> Unit,

    val remoteStageOptions: DslContext<StageOption>.() -> Unit,
    val defaultAgent: SingletonDslContext<Agent>.() -> Unit,

    val stageContext: () -> I,
    val stages: Deque<Stage> = LinkedBlockingDeque()
) : DslContext<Stage>(items = stages), MethodDsl {
    fun DslContext<Step>.beforeLocalStage() { beforeLocalStage.invoke(this) }
    fun DslContext<Step>.afterLocalStage() { afterLocalStage.invoke(this) }
    fun DslContext<Step>.beforeRemoteStage() { beforeRemoteStage.invoke(this) }
    fun DslContext<Step>.afterRemoteStage() { afterRemoteStage.invoke(this) }

    fun PostContext.beforeLocalStagePost() { beforeLocalStagePost.invoke(this) }
    fun PostContext.afterLocalStagePost() { afterLocalStagePost.invoke(this) }
    fun PostContext.beforeRemoteStagePost() { beforeRemoteStagePost.invoke(this) }
    fun PostContext.afterRemoteStagePost() { afterRemoteStagePost.invoke(this) }

    fun DslContext<StageOption>.remoteStageOptions() { remoteStageOptions.invoke(this) }

    fun SingletonDslContext<Agent>.defaultAgent() { defaultAgent.invoke(this) }

    private fun getDefaultAgent(): Agent? {
        return SingletonDslContext.into(defaultAgent)
    }

    // TODO, move remote stage and local stage into stage
    fun stage(
        name: String,
        stageBlock: I.() -> Unit
    ) {
        val stageContext = stageContext()
        stageContext.stageBlock()
        val stage = stageContext.toStage(name)

        val configuredStage = if (stage.agent != null) {
            when (stage) {
                is Stage.Steps ->
                    stage.copy(
                            options = getRemoteStageOptions(stage.options),
                            steps = applyBeforeAndAfterRemoteSteps(name, stage.steps),
                            post = applyBeforeAndAfterRemotePost(stage.post))
                    else -> stage
            }
        } else {
            when (stage) {
                is Stage.Steps ->
                    stage.copy(
                            steps = applyBeforeAndAfterLocalSteps(name, stage.steps),
                            post = applyBeforeAndAfterLocalPost(stage.post))
                else -> stage
            }
        }

        add(configuredStage)
    }

    private fun getRemoteStageOptions(stageOptions: List<StageOption>): List<StageOption> {
        val context = DslContext<StageOption>()
        context.remoteStageOptions()
        val defaultOptions = context.drainAll()
                .filter { defaultOption -> stageOptions.none { userOption -> userOption.javaClass == defaultOption.javaClass } }
        return stageOptions + defaultOptions
    }

    private fun applyBeforeAndAfterLocalPost(post: Post): Post {
        val beforePostContext = PostContext()
        beforePostContext.beforeLocalStagePost()
        val beforePost = beforePostContext.toPost()

        val afterPostContext = PostContext()
        afterPostContext.afterLocalStagePost()
        val afterPost = afterPostContext.toPost()

        return beforePost.merge(post).merge(afterPost)
    }

    private fun applyBeforeAndAfterRemotePost(post: Post): Post {
        val beforePostContext = PostContext()
        beforePostContext.beforeRemoteStagePost()
        val beforePost = beforePostContext.toPost()

        val afterPostContext = PostContext()
        afterPostContext.afterRemoteStagePost()
        val afterPost = afterPostContext.toPost()

        return beforePost.merge(post).merge(afterPost)
    }

    private fun applyBeforeAndAfterLocalSteps(name: String, steps: Step): Step {
        val method = method(name.replace("\\W".toRegex(), "_")) {
            beforeLocalStage()
            add(steps)
            afterLocalStage()
        }

        return DslContext.into<Step> { invoke(method) }.toStep()
    }

    private fun applyBeforeAndAfterRemoteSteps(name: String, steps: Step): Step {
        val method = method(name.replace("\\W".toRegex(), "_")) {
            beforeRemoteStage()
            add(steps)
            afterRemoteStage()
        }

        return DslContext.into<Step> { invoke(method) }.toStep()
    }
}
