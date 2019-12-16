package com.code42.jenkins.pipelinekt.internal.step.scripted

import com.code42.jenkins.pipelinekt.core.step.ScriptedStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class ReadProperties(val file: Var) : ScriptedStep, SingletonStep {

    override fun scriptedGroovy(writer: GroovyWriter) {
        writer.writeln("readProperties file: ${file.toGroovy()}")
    }
}
