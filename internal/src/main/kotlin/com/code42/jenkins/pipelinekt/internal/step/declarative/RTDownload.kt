package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.artifactory.RTSpec
import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 *
 * Generates the necessary code to download artifacts to Artifactory
 *
 * @param serverID the server id to download from
 * @param buildName the build name
 * @param buildNumber the build number
 * @param failNoOp specifies whether to fail the build in case no files are downloaded
 * @param spec an object representing File spec(s), which specifies the files that should be downloaded
 * @param specPath path to a File that manages FIle spec(s) (rather than adding it to a closure like the spec property)
 */
data class RTDownload(
    override val serverID: Var.Literal.Str,
    override val buildName: Var.Literal.Str? = null,
    override val buildNumber: Var.Literal.Str? = null,
    override val failNoOp: Var.Literal.Bool = false.boolVar(),
    override val spec: RTSpec? = null,
    override val specPath: Var.Literal.Str? = null
) : RTBase(), DeclarativeStep, SingletonStep {
    override val rtCommand = "rtDownload"

    override fun toGroovy(writer: GroovyWriter) {
        rtUploadOrDownloadToGroovy(writer)
    }
}
