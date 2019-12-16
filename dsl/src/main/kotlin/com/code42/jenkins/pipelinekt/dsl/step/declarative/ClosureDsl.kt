package com.code42.jenkins.pipelinekt.dsl.step.declarative

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.ext.toStep
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.declarative.Closure
import com.code42.jenkins.pipelinekt.internal.step.declarative.ClosureInvocation

fun DslContext<Step>.invokeClosure(name: String, arguments: List<Var> = emptyList()) {
    add(ClosureInvocation(name, arguments))
}

fun DslContext<Step>.invokeClosure(closureVariable: Var.Variable, arguments: List<Var> = emptyList()) {
    add(ClosureInvocation(closureVariable.name, arguments))
}

fun DslContext<Step>.closureDeclaration(steps: DslContext<Step>.() -> Unit) {
    add(Closure(DslContext.into(steps).toStep()))
}
