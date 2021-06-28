package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.NestedStep
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * Inject secrets to some steps
 *
 * @param secrets the secrets to inject
 * @param steps the steps to inject
 */
data class WrapPass(val secrets: List<String>, override val steps: Step) : DeclarativeStep, NestedStep {
    override fun toGroovy(writer: GroovyWriter) {
        // wrap([$class: 'MaskPasswordsBuildWrapper', varPasswordPairs: [[password: URL]]]) {

        val body = StringBuilder()
        val listIterator = secrets.listIterator()
        body.appendln("wrap([\$class: 'MaskPasswordsBuildWrapper', varPasswordPairs: [")
        while (listIterator.hasNext()) {
            val secretValue = listIterator.next()
            body.appendln(
                "    [var: '$secretValue', password: '\${$secretValue}']" +
                        (if (listIterator.hasNext()) "," else "")
            )
        }
        body.appendln("]])")
        writer.closure(body.toString(), steps::toGroovy)
    }
}
