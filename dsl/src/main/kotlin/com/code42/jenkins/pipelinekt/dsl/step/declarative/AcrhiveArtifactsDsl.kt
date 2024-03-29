package com.code42.jenkins.pipelinekt.dsl.step.declarative

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.declarative.ArchiveArtifacts

fun DslContext<Step>.archiveArtifacts(artifacts: String, fingerprint: Boolean) =
    archiveArtifacts(artifacts.strDouble(), fingerprint, false)

fun DslContext<Step>.archiveArtifacts(artifacts: String, fingerprint: Boolean, allowEmptyArchive: Boolean) =
    archiveArtifacts(artifacts.strDouble(), fingerprint, allowEmptyArchive)

fun DslContext<Step>.archiveArtifacts(artifacts: Var.Literal.Str, fingerprint: Boolean) {
    add(ArchiveArtifacts(artifacts, fingerprint, false))
}
fun DslContext<Step>.archiveArtifacts(artifacts: Var.Literal.Str, fingerprint: Boolean, allowEmptyArchive: Boolean) {
    add(ArchiveArtifacts(artifacts, fingerprint, allowEmptyArchive))
}
