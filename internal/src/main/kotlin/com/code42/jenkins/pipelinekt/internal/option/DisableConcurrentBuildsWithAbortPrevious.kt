package com.code42.jenkins.pipelinekt.internal.option

import com.code42.jenkins.pipelinekt.core.Option
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

object DisableConcurrentBuildsWithAbortPrevious : Option {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("disableConcurrentBuilds(abortPrevious: true)")
    }
}
