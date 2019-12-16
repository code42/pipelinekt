package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 *
 * Execute a shell command
 *
 * @param script the shell script to execute
 */
data class Bat(val script: Var.Literal.Str, val returnStdout: Var.Literal.Bool = false.boolVar(), val label: Var.Literal.Str? = null) : DeclarativeStep, SingletonStep {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("bat (script: ${script.toGroovy()}, returnStdout: ${returnStdout.toGroovy()}${labelGroovy()})")
    }

    private fun labelGroovy(): String = label?.let { ", label: ${label.toGroovy()}" } ?: ""
}
