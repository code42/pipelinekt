package com.code42.jenkins.pipelinekt.internal.step.scripted

import com.code42.jenkins.pipelinekt.core.step.ScriptedStep
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * Workspace step - executes steps within a custom workspace directory
 * @param path The path to use as the workspace directory
 * @param steps Steps to run within the custom workspace
 */
data class Ws(
    val path: Var.Literal.Str,
    val steps: Step
) : ScriptedStep {
    override fun toGroovy(writer: GroovyWriter) {
        writer.closure("ws(${path.toGroovy()})") { innerWriter ->
            steps.toGroovy(innerWriter)
        }
    }
}