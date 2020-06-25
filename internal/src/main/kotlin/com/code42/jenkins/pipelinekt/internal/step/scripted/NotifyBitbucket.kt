package com.code42.jenkins.pipelinekt.internal.step.scripted

import com.code42.jenkins.pipelinekt.core.step.ScriptedStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * Notify Bitbucket server of build status.  Use at the beginning and end of a pipeline.
 */
object NotifyBitbucket : ScriptedStep, SingletonStep {
    override fun scriptedGroovy(writer: GroovyWriter) {
        writer.writeln("notifyBitbucket()")
    }
}

data class NotifyBitbucketSha1(
    val sha1: String
) : ScriptedStep, SingletonStep {
    override fun scriptedGroovy(writer: GroovyWriter) {
        writer.writeln("notifyBitbucket($sha1)")
    }
}
