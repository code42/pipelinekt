package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class CleanWs(val deleteDirs: Boolean, val disableDeferredWipeout: Boolean) : DeclarativeStep, SingletonStep {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("cleanWs(deleteDirs: $deleteDirs, disableDeferredWipeout: $disableDeferredWipeout)")
    }
}
