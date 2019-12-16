package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * Execute archive artifacts command
 *
 * @param artifacts the artifacts to archive, blob pattern
 * @param fingerprint whether the artifact is part of the archives fingerprints
 */
data class ArchiveArtifacts(val artifacts: Var.Literal.Str, val fingerprint: Boolean = false) : DeclarativeStep, SingletonStep {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("archiveArtifacts artifacts: ${artifacts.toGroovy()}, fingerprint: $fingerprint")
    }
}
