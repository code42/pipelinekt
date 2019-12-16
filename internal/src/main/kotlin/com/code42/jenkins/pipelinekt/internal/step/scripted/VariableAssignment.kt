package com.code42.jenkins.pipelinekt.internal.step.scripted

import com.code42.jenkins.pipelinekt.core.step.NestedStep
import com.code42.jenkins.pipelinekt.core.step.ScriptedStep
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * Declare a variable and assign it to the output of some steps
 *
 * @param
 */
data class VariableAssignment(val variable: Var.Variable, override val steps: Step) : ScriptedStep, NestedStep {
    override fun scriptedGroovy(writer: GroovyWriter) {
        writer.writeln("${variable.toGroovy()} =")
        steps.toGroovy(writer.copy(indent = writer.indent + 1))
    }
}
