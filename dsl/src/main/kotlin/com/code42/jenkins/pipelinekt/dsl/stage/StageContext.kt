package com.code42.jenkins.pipelinekt.dsl.stage

import com.code42.jenkins.pipelinekt.core.Agent
import com.code42.jenkins.pipelinekt.core.StageOption
import com.code42.jenkins.pipelinekt.core.Tool
import com.code42.jenkins.pipelinekt.core.When
import com.code42.jenkins.pipelinekt.core.stage.Stage
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.dsl.SingletonDslContext
import com.code42.jenkins.pipelinekt.dsl.post.PostContext

interface StageContext {
    fun steps(stepsBlock: DslContext<Step>.() -> Unit)

    fun stages(stagesBlock: StageWrapperContext<NestedStageContext>.() -> Unit)

    fun parallel(stagesBlock: StageWrapperContext<NestedStageContext>.() -> Unit)

    fun agent(agentBlock: SingletonDslContext<Agent>.() -> Unit)

    fun `when`(whenBlock: DslContext<When>.() -> Unit)

    fun tools(toolsBlock: DslContext<Tool>.() -> Unit)

    fun options(optionsBlock: DslContext<StageOption>.() -> Unit)

    fun post(postBlocck: PostContext.() -> Unit)

    fun toStage(name: String): Stage

    fun matrix(matrixBlock: MatrixContext.() -> Unit)
}
