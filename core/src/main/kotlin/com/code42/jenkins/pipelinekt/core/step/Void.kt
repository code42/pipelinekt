package com.code42.jenkins.pipelinekt.core.step

import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * An empty step
 */
object Void : DeclarativeStep, SingletonStep {
    override fun toGroovy(writer: GroovyWriter) {}

    override fun andThen(next: Step): Step {
        return next
    }

    override fun precededBy(previous: Step): Step {
        return previous
    }

    override fun isEmpty() = true
}
