package com.code42.jenkins.pipelinekt.core.method

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.writer.GroovyScript
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class PipelineMethod(
    val name: String,
    val steps: Step
) : GroovyScript {

    companion object {
        /**
         * Static method, recommended for internal use only.
         * Users: Please favor PipelineMethodDsl.
         */
        fun invocation(method: PipelineMethod): PipelineMethodInvocation {
            return PipelineMethodInvocation(method.name)
        }
    }

    override fun toGroovy(writer: GroovyWriter) {
        writer.closure("def $name()", steps::toGroovy)
    }
}
