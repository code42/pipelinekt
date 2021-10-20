package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.NestedStep
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * Wraps a block in the withFolderProperties dsl allowing access to environment variables defined on the folder.
 *
 * @param steps the steps to inject
 */
data class WithFolderProperties(override val steps: Step) : DeclarativeStep, NestedStep {
    override fun toGroovy(writer: GroovyWriter) {
        writer.closure(listOf("withFolderProperties"), steps::toGroovy)
    }
}
