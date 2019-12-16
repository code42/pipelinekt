package com.code42.jenkins.pipelinekt.dsl.step.scripted

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.groovyVariable
import com.code42.jenkins.pipelinekt.core.writer.ext.toStep
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.declarative.Literal
import com.code42.jenkins.pipelinekt.internal.step.scripted.VariableAssignment

fun DslContext<Step>.def(steps: DslContext<Step>.() -> Unit): Var.Variable =
    def(generateVariableName(), steps)

fun DslContext<Step>.def(variableName: String, steps: DslContext<Step>.() -> Unit): Var.Variable {
    val variable = variableName.groovyVariable()
    add(Literal("def ${variable.name}"))
    add(VariableAssignment(variable, DslContext.into(steps).toStep()))
    return variable
}

fun DslContext<Step>.def(value: Var): Var.Variable =
        def(generateVariableName(), value)
fun DslContext<Step>.def(variableName: String, value: Var): Var.Variable =
        def(variableName, { literal(value.toGroovy()) })

fun DslContext<Step>.assign(variable: Var.Variable, steps: DslContext<Step>.() -> Unit): Var.Variable {
    add(VariableAssignment(variable, DslContext.into(steps).toStep()))
    return variable
}

fun DslContext<Step>.assign(variable: Var.Variable, value: Var): Var.Variable =
        assign(variable, { literal(value.toGroovy()) })

private fun generateVariableName(length: Int = 8): String {
    val allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz"
    return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
}
