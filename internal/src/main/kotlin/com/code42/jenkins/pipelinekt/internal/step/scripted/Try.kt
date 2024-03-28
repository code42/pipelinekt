package com.code42.jenkins.pipelinekt.internal.step.scripted

import com.code42.jenkins.pipelinekt.core.step.NestedStep
import com.code42.jenkins.pipelinekt.core.step.ScriptedStep
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.step.Void
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class Try(
    val tryStep: Step,
    val catchStep: Step? = null
) : ScriptedStep, NestedStep {

    // I suspect that `steps` is only used by `isEmpty()`, that's why tryStep and catchStep bodies are concatenated
    override val steps: Step
        get() = tryStep.andThen(catchStep ?: Void)

    override fun scriptedGroovy(writer: GroovyWriter) {
        writer.closure("try", tryStep::toGroovy)
        catchStep?.let { writer.closure("catch(exc)", it::toGroovy) }
    }
}
