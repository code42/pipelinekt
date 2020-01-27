package com.code42.jenkins.pipelinekt.internal.option

import com.code42.jenkins.pipelinekt.core.StageOption
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter
import java.util.concurrent.TimeUnit

data class Timeout(val time: Var.Literal.Int, val unit: TimeUnit) : StageOption {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("timeout(time: ${time.toGroovy()}, unit: '$unit')")
    }
}
