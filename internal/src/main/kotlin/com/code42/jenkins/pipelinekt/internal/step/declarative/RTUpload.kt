package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.artifactory.RTSpec
import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 *
 * Generates the necessary code to upload artifacts to Artifactory
 *
 * @param serverID the server id to upload to
 * @param buildName the build name
 * @param buildNumber the build number
 * @param failNoOp specifies whether to fail the build in case no files are uploaded or downloaded
 * @param spec an object representing File spec(s), which specifies the files that should be uploaded
 * @param specPath path to a File that manages FIle spec(s) (rather than adding it to a closure like the spec property)
 */
data class RTUpload(
    override val serverID: Var.Literal.Str,
    override val buildName: Var.Literal.Str? = null,
    override val buildNumber: Var.Literal.Str? = null,
    override val failNoOp: Var.Literal.Bool = false.boolVar(),
    override val spec: RTSpec? = null,
    override val specPath: Var.Literal.Str? = null
) : RTBase(), DeclarativeStep, SingletonStep {
    override val rtCommand = "rtUpload"

    override fun toGroovy(writer: GroovyWriter) {
        rtUploadOrDownloadToGroovy(writer)
    }
}
