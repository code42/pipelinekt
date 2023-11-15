package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.secrets.Secrets
import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.NestedStep
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * Make Secrets from Vault available to steps within the block.
 *
 * @param secrets the list secrets made available to the steps
 * @param steps the steps to inject
 */
data class WithVault(val secrets: Secrets, override val steps: Step) : DeclarativeStep, NestedStep {
    override fun toGroovy(writer: GroovyWriter) {

        // The version of the Vault plugin we are using still has this issue, trying to access a secret that doesn't exist will fail silently.
        // https://github.com/jenkinsci/hashicorp-vault-plugin/pull/257

        var stepsPrefixedWithVaultEmptyResultWarnings = steps
        secrets.getEnvironmentVariableNames().reversed().forEach {
            val errorMessage = "WARNING: environment variable '$it' was not set, or was empty. Getting secrets from vault may have failed. ";
            stepsPrefixedWithVaultEmptyResultWarnings = stepsPrefixedWithVaultEmptyResultWarnings.precededBy(
                    Sh(script = "if [ ! \\\"\$$it\\\" ]; then echo \\\"$errorMessage\\\"; fi".strDouble())
            )
        }

        writer.closure(listOf("withVault([") + secrets.toGroovy() + "])", stepsPrefixedWithVaultEmptyResultWarnings::toGroovy)
    }
}
