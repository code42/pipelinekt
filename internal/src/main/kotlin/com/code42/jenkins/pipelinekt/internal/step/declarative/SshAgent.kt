package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.NestedStep
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class SshAgent(val credentials: List<Var.Literal.Str>, override val steps: Step, val ignoreMissing: Var.Literal.Bool? = null) : DeclarativeStep, NestedStep {
    override fun toGroovy(writer: GroovyWriter) {
        writer.closure("sshagent(credentials: [${credentials.map { it.toGroovy() }.joinToString(",")}]${ignoreMissing?.let { ", ignoreMissing: ${it.toGroovy()}"} ?: ""})", steps::toGroovy)
    }
}
