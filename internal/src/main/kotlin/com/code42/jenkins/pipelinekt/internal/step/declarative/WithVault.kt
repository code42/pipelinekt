package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.secrets.Secrets
import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.NestedStep
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * Make Secrets from Vault available to steps within the block.
 *
 * @param secrets the list secrets made available to the steps
 * @param steps the steps to inject
 */
data class WithVault(val secrets: Secrets, override val steps: Step) : DeclarativeStep, NestedStep {
    override fun toGroovy(writer: GroovyWriter) {
        writer.closure(listOf("withVault([") + secrets.toGroovy() + "])", steps::toGroovy)
    }
}
