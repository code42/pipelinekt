package com.code42.jenkins.pipelinekt.dsl.stage

import com.code42.jenkins.pipelinekt.core.Agent
import com.code42.jenkins.pipelinekt.core.StageOption
import com.code42.jenkins.pipelinekt.core.Tool
import com.code42.jenkins.pipelinekt.core.When
import com.code42.jenkins.pipelinekt.core.stage.Stage
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.writer.ext.toStep
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.dsl.SingletonDslContext
import com.code42.jenkins.pipelinekt.dsl.post.PostContext

@Suppress("LongParameterList")
open class NestedStageContext(
    val agentContext: SingletonDslContext<Agent> = SingletonDslContext(),
    val stepContext: DslContext<Step> = DslContext(),
    val nestedStageContext: StageWrapperContext<NestedStageContext>,
    val postContext: PostContext = PostContext(),
    val whenContext: DslContext<When> = DslContext(),
    val toolContext: DslContext<Tool> = DslContext(),
    val optionContext: DslContext<StageOption> = DslContext()
) : StageContext {

    override fun steps(stepBlock: DslContext<Step>.() -> Unit) {
        stepContext.stepBlock()
    }

    override fun stages(stagesBlock: StageWrapperContext<NestedStageContext>.() -> Unit) {
        nestedStageContext.stagesBlock()
    }

    /**
     * This method is here to prevent calling parallel in nested stages.  This method should never be invoked.
     *
     * Parallel stages are only valid from the top level
     */
    @Deprecated("Nested Parallel stages not Implemented in Jenkins")
    override fun parallel(stagesBlock: StageWrapperContext<NestedStageContext>.() -> Unit) {
        throw NotImplementedError("Nested Parallel stages not implemented in Jenkins")
    }

    /**
     * This method is here to prevent calling parallel in nested stages.  This method should never be invoked.
     *
     * Matrix stages are only valid from the top level
     */
    override fun matrix(matrixBlock: MatrixContext.() -> Unit) {
        throw NotImplementedError("Nested matrix stages not implemented in Jenkins")
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

        if (sequentialStages.size > 0) {
            return Stage.Sequence(
                    name.strDouble(),
                    sequentialStages,
                    agentContext.drainAll().firstOrNull(),
                    whenContext.drainAll(),
                    toolContext.drainAll(),
                    optionContext.drainAll(),
                    postContext.toPost())
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
