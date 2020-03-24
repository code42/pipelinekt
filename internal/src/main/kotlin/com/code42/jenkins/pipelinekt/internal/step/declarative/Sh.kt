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
 * @param script The shell script or command to execute.
 * @param returnStdout If checked, standard output from the task is returned as the step value as a String, rather than being printed to the build log. (Standard error, if any, will still be printed to the log.) You will often want to call .trim() on the result to strip off a trailing newline.
 * @param label Label to be displayed in the pipeline step view and blue ocean details for the step instead of the step type. So the view is more meaningful and domain specific instead of technical.
 */
data class Sh(val script: Var.Literal.Str, val returnStdout: Var.Literal.Bool = false.boolVar(), val label: Var.Literal.Str? = null) : DeclarativeStep, SingletonStep {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("sh (script: ${script.toGroovy()}, returnStdout: ${returnStdout.toGroovy()}${labelGroovy()})")
    }

    private fun labelGroovy(): String = label?.let { ", label: ${label.toGroovy()}" } ?: ""
}
