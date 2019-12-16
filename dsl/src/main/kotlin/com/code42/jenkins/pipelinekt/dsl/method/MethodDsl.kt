package com.code42.jenkins.pipelinekt.dsl.method

import com.code42.jenkins.pipelinekt.core.method.PipelineMethod
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.writer.ext.toStep
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.dsl.into

interface MethodDsl {
    val pipelineMethodRegistry: PipelineMethodRegistry

    fun method(
        name: String,
        steps: DslContext<Step>.() -> Unit
    ): PipelineMethod {
        val methodSteps = DslContext<Step>().into { steps() }.toStep()
        return PipelineMethod(name, methodSteps)
    }

    fun DslContext<Step>.invoke(method: PipelineMethod) {
        pipelineMethodRegistry.registerMethod(method)
        add(PipelineMethod.invocation(method))
    }
}
