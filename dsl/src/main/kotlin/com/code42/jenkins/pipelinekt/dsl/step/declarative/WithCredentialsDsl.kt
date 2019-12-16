package com.code42.jenkins.pipelinekt.dsl.step.declarative

import com.code42.jenkins.pipelinekt.core.credentials.JenkinsCredentials
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.writer.ext.toStep
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.declarative.WithCredentials

fun DslContext<Step>.withCredentials(credentials: JenkinsCredentials, steps: DslContext<Step>.() -> Unit) {
    add(WithCredentials(credentials, DslContext.into(steps).toStep()))
}
