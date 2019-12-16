package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.credentials.JenkinsCredentials
import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.NestedStep
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * Inject credentials to some steps
 *
 * @param credentials the credentials to inject
 * @param steps the steps to inject
 */
data class WithCredentials(val credentials: JenkinsCredentials, override val steps: Step) : DeclarativeStep, NestedStep {
    override fun toGroovy(writer: GroovyWriter) {
        writer.closure(listOf("withCredentials([[") + credentials.toGroovy().map { "${writer.indentStr}$it" } + "]])", steps::toGroovy)
    }
}
