package com.code42.jenkins.pipelinekt.core

import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class TestStep(val text: String) : SingletonStep, DeclarativeStep {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln(text)
    }
}
