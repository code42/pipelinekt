package com.code42.jenkins.pipelinekt.internal.option

import com.code42.jenkins.pipelinekt.core.Option
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class AnsiColor(val colorMapName: Var.Literal.Str) : Option {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("ansiColor(${colorMapName.toGroovy()})")
    }
}
