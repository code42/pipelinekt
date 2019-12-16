package com.code42.jenkins.pipelinekt.internal.option

import com.code42.jenkins.pipelinekt.core.StageOption
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class Retry(val times: Var.Literal.Int) : StageOption {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("retry(${times.toGroovy()})")
    }
}
