package com.code42.jenkins.pipelinekt.dsl.stage

import com.code42.jenkins.pipelinekt.core.Agent
import com.code42.jenkins.pipelinekt.core.StageOption
import com.code42.jenkins.pipelinekt.core.Tool
import com.code42.jenkins.pipelinekt.core.When
import com.code42.jenkins.pipelinekt.core.stage.MatrixExclude
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.dsl.SingletonDslContext
import com.code42.jenkins.pipelinekt.dsl.into
import com.code42.jenkins.pipelinekt.dsl.post.PostContext

fun DslContext<MatrixExclude>.exclude(excludeBlock: MatrixExcludeAxisContext.() -> Unit) {
    add(MatrixExclude(MatrixExcludeAxisContext().into(excludeBlock)))
}

data class MatrixContext(
    val nestedStageContext: StageWrapperContext<NestedStageContext>,
    val axesContext: MatrixAxisContext = MatrixAxisContext(),
    val excludesContext: DslContext<MatrixExclude> = DslContext(),
    val agentContext: SingletonDslContext<Agent> = SingletonDslContext(),
    val whenContext: DslContext<When> = DslContext(),
    val toolContext: DslContext<Tool> = DslContext(),
    val optionContext: DslContext<StageOption> = DslContext(),
    val postContext: PostContext = PostContext()
) {
    fun stages(stagesBlock: StageWrapperContext<NestedStageContext>.() -> Unit) {
        nestedStageContext.stagesBlock()
    }

    fun axes(axesBlock: MatrixAxisContext.() -> Unit) {
        axesContext.axesBlock()
    }

    fun excludes(excludesBlock: DslContext<MatrixExclude>.() -> Unit) {
        excludesContext.excludesBlock()
    }

    fun agent(agentBlock: SingletonDslContext<Agent>.() -> Unit) {
        agentContext.agentBlock()
    }

    fun `when`(whenBlock: DslContext<When>.() -> Unit) {
        whenContext.whenBlock()
    }

    fun tools(toolsBlock: DslContext<Tool>.() -> Unit) {
        toolContext.toolsBlock()
    }

    fun options(optionsBlock: DslContext<StageOption>.() -> Unit) {
        optionContext.optionsBlock()
    }

    fun post(postBlock: PostContext.() -> Unit) {
        postContext.postBlock()
    }
}
