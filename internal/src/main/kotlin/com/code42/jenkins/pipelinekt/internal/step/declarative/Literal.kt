package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * Define arbitrary Declarative Jenkinsfile code blocks
 *
 * @param codeBlock a literal code block to inject into the generated Jenkinsfile
 */
data class
Literal(val codeBlock: String) : DeclarativeStep, SingletonStep {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln(codeBlock)
    }
}
