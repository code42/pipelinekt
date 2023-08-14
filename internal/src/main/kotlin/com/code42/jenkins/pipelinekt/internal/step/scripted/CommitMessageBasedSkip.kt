package com.code42.jenkins.pipelinekt.internal.step.scripted

import com.code42.jenkins.pipelinekt.core.step.ScriptedStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * Use this to abort a job based on a regex pattern match in the latest commit message.
 *
 * This requires approval of the following signature which isn't normally allowed in the Groovy sandbox.
 * new org.jenkinsci.plugins.workflow.steps.FlowInterruptedException hudson.model.Result jenkins.model.CauseOfInterruption[]
 */

@Suppress("MaxLineLength")
data class CommitMessageBasedSkip(
    val regex: String = "\\\\[ci skip\\\\]",
    val result: String = "SUCCESS"
) : ScriptedStep, SingletonStep {
    override fun scriptedGroovy(writer: GroovyWriter) {
        writer.writeln(
            """
                script {
                    try {
                        sh "if git log --oneline -1 | grep -qE '$regex'; then exit 1; fi"
                    } catch(exc) {
                        throw new FlowInterruptedException(Result.$result)
                    }
                }
            """.trimIndent()
        )
    }
}
