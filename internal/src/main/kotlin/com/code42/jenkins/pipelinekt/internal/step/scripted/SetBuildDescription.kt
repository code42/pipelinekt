package com.code42.jenkins.pipelinekt.internal.step.scripted

import com.code42.jenkins.pipelinekt.core.step.ScriptedStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * Set the description of a build.
 *
 * @param description The description of this build.
 */
data class SetBuildDescription(val description: String) : ScriptedStep, SingletonStep {
    override fun scriptedGroovy(writer: GroovyWriter) {
        writer.writeln("currentBuild.description = \"${description}\"")
    }
}
