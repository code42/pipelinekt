package com.code42.jenkins.pipelinekt.internal.option

import com.code42.jenkins.pipelinekt.core.StageOption
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

object Timestamps : StageOption {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("timestamps()")
    }
}
