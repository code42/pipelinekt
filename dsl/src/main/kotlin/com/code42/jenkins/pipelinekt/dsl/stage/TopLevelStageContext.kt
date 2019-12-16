package com.code42.jenkins.pipelinekt.dsl.stage

import com.code42.jenkins.pipelinekt.core.Agent
import com.code42.jenkins.pipelinekt.core.StageOption
import com.code42.jenkins.pipelinekt.core.Tool
import com.code42.jenkins.pipelinekt.core.When
import com.code42.jenkins.pipelinekt.core.stage.MatrixBody
import com.code42.jenkins.pipelinekt.core.stage.Stage
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.writer.ext.toStep
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.dsl.SingletonDslContext
import com.code42.jenkins.pipelinekt.dsl.post.PostContext

open class TopLevelStageContext(
    val agentContext: SingletonDslContext<Agent> = SingletonDslContext(),
    val stepContext: DslContext<Step> = DslContext(),
    val parallelStageContext: StageWrapperContext<NestedStageContext>,
    val nestedStageContext: StageWrapperContext<NestedStageContext>,
    val matrixContext: MatrixContext,
    val postContext: PostContext = PostContext(),
    val whenContext: DslContext<When> = DslContext(),
    val toolContext: DslContext<Tool> = DslContext(),
    val optionContext: DslContext<StageOption> = DslContext()
) : StageContext {

    override fun steps(stepsBlock: DslContext<Step>.() -> Unit) {
        stepContext.stepsBlock()
    }

    override fun stages(stagesBlock: StageWrapperContext<NestedStageContext>.() -> Unit) {
        nestedStageContext.stagesBlock()
    }

    override fun parallel(stagesBlock: StageWrapperContext<NestedStageContext>.() -> Unit) {
        parallelStageContext.stagesBlock()
    }

    override fun matrix(matrixBlock: MatrixContext.() -> Unit) {
        matrixContext.matrixBlock()
    }

    override fun agent(agentBlock: SingletonDslContext<Agent>.() -> Unit) {
        agentContext.agentBlock()
    }

    override fun `when`(whenBlock: DslContext<When>.() -> Unit) {
        whenContext.whenBlock()
    }

    override fun tools(toolsBlock: DslContext<Tool>.() -> Unit) {
        toolContext.toolsBlock()
    }

    override fun options(optionsBlock: DslContext<StageOption>.() -> Unit) {
        optionContext.optionsBlock()
    }

    override fun post(postBlocck: PostContext.() -> Unit) {
        postContext.postBlocck()
    }

    override fun toStage(name: String): Stage {
        val steps = stepContext.drainAll()
        val sequentialStages = nestedStageContext.drainAll()
        val parallelStages = parallelStageContext.drainAll()
        val matrixStages = matrixContext.nestedStageContext.drainAll()

        if (sequentialStages.size > 0) {
            return Stage.Sequence(
                    name.strDouble(),
                    sequentialStages,
                    agentContext.drainAll().firstOrNull(),
                    whenContext.drainAll(),
                    toolContext.drainAll(),
                    optionContext.drainAll(),
                    postContext.toPost())
        } else if (parallelStages.size > 0) {
            return Stage.Parallel(
                    name.strDouble(),
                    parallelStages,
                    agentContext.drainAll().firstOrNull(),
                    whenContext.drainAll(),
                    toolContext.drainAll(),
                    optionContext.drainAll(),
                    postContext.toPost())
        } else if (matrixStages.isNotEmpty()) {
            return Stage.Matrix(
                    name.strDouble(),
                    MatrixBody(
                            matrixContext.axesContext.drainAll(),
                            matrixContext.excludesContext.drainAll(),
                            matrixStages,
                            matrixContext.agentContext.drainAll().firstOrNull(),
                            matrixContext.whenContext.drainAll(),
                            matrixContext.toolContext.drainAll(),
                            matrixContext.optionContext.drainAll(),
                            matrixContext.postContext.toPost()
                    ),
                    whenContext.drainAll(),
                    optionContext.drainAll(),
                    postContext.toPost()
            )
        } else {
            return Stage.Steps(
                    name.strDouble(),
                    steps.toStep(),
                    agentContext.drainAll().firstOrNull(),
                    whenContext.drainAll(),
                    toolContext.drainAll(),
                    optionContext.drainAll(),
                    postContext.toPost())
        }
    }
}
