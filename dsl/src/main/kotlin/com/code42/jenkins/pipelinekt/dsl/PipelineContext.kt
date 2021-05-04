package com.code42.jenkins.pipelinekt.dsl

import com.code42.jenkins.pipelinekt.core.Agent
import com.code42.jenkins.pipelinekt.core.Environment
import com.code42.jenkins.pipelinekt.core.Option
import com.code42.jenkins.pipelinekt.core.Parameter
import com.code42.jenkins.pipelinekt.core.Tool
import com.code42.jenkins.pipelinekt.core.Trigger
import com.code42.jenkins.pipelinekt.dsl.method.PipelineMethodRegistry
import com.code42.jenkins.pipelinekt.dsl.post.PostContext
import com.code42.jenkins.pipelinekt.dsl.stage.StageWrapperContext
import com.code42.jenkins.pipelinekt.dsl.stage.TopLevelStageContext

data class PipelineContext(
    val environmentContext: DslContext<Environment> = DslContext(),
    val agentContext: SingletonDslContext<Agent> = SingletonDslContext(),
    val triggersContext: DslContext<Trigger> = DslContext(),
    val parametersContext: DslContext<Parameter> = DslContext(),
    val toolContext: DslContext<Tool> = DslContext(),
    val optionContext: DslContext<Option> = DslContext(),
    val topLevelStageContext: StageWrapperContext<TopLevelStageContext>,
    val postContext: PostContext = PostContext(),
    val pipelineMethodRegistry: PipelineMethodRegistry
) {

    fun stages(stagesBlock: StageWrapperContext<TopLevelStageContext>.() -> Unit) {
        topLevelStageContext.stagesBlock()
    }

    fun triggers(triggersBlock: DslContext<Trigger>.() -> Unit) {
        triggersContext.triggersBlock()
    }

    fun parameters(parametersBlock: DslContext<Parameter>.() -> Unit) {
        parametersContext.parametersBlock()
    }

    fun tools(toolsBlock: DslContext<Tool>.() -> Unit) {
        toolContext.toolsBlock()
    }

    fun options(optionsBlock: DslContext<Option>.() -> Unit) {
        optionContext.optionsBlock()
    }

    fun agent(agentBlock: SingletonDslContext<Agent>.() -> Unit) {
        agentContext.agentBlock()
    }

    fun post(postBlock: PostContext.() -> Unit) {
        postContext.postBlock()
    }

    fun environment(environmentBlock: DslContext<Environment>.() -> Unit) {
        environmentContext.environmentBlock()
    }
}
