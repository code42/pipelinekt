package com.code42.jenkins.pipelinekt.core.step

import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * Ensure that the pipeline is in ScriptedStep context.  These steps will not be run in the declarative context.
 */
interface ScriptedStep : Step {

    override fun toGroovy(writer: GroovyWriter) {
        writer.scripted(this::scriptedGroovy)
    }

    fun scriptedGroovy(writer: GroovyWriter)
}
