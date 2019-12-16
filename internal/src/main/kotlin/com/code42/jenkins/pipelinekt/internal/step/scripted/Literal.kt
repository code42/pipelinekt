package com.code42.jenkins.pipelinekt.internal.step.scripted

import com.code42.jenkins.pipelinekt.core.step.ScriptedStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * Define arbitrary scripted Jenkinsfile code blocks
 *
 * @param codeBlock a literal code block to inject into the generated Jenkinsfile
 */
data class Literal(val codeBlock: String) : ScriptedStep, SingletonStep {
    override fun scriptedGroovy(writer: GroovyWriter) {
        writer.writeln(codeBlock)
    }
}
