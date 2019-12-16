package com.code42.jenkins.pipelinekt.internal.`when`

import com.code42.jenkins.pipelinekt.core.When
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class Changelog(val regex: Var.Literal.Str) : When {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("changelog ${regex.toGroovy()}")
    }
}
