package com.code42.jenkins.pipelinekt.dsl.step.declarative

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.writer.ext.toStep
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.declarative.SshAgent

fun DslContext<Step>.sshAgent(credentals: List<String>, steps: DslContext<Step>.() -> Unit, ignoreMissing: Boolean? = null) =
        sshAgent(credentals.map { it.strDouble() }, steps, ignoreMissing?.boolVar())

fun DslContext<Step>.sshAgent(credentals: List<Var.Literal.Str>, steps: DslContext<Step>.() -> Unit, ignoreMissing: Var.Literal.Bool? = null) {
    val innerContext = DslContext<Step>()
    innerContext.steps()
    add(SshAgent(credentals, innerContext.drainAll().toStep(), ignoreMissing))
}
