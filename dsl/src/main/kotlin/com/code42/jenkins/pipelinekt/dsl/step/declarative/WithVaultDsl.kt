package com.code42.jenkins.pipelinekt.dsl.step.declarative

import com.code42.jenkins.pipelinekt.core.secrets.Secrets
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.writer.ext.toStep
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.declarative.WithVault

fun DslContext<Step>.withVault(secrets: Secrets, steps: DslContext<Step>.() -> Unit) {
    add(WithVault(secrets, DslContext.into(steps).toStep()))
}
