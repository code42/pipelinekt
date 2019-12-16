package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.NestedStep
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class Closure(override val steps: Step) : DeclarativeStep, NestedStep {
    override fun toGroovy(writer: GroovyWriter) {
        if (steps.isEmpty()) {
            writer.writeln("{ }")
        } else {
            writer.writeln("{")
            steps.toGroovy(writer.inner())
            writer.writeln("}")
        }
    }
}
