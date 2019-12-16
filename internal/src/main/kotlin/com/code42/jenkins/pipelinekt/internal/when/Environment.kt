package com.code42.jenkins.pipelinekt.internal.`when`

import com.code42.jenkins.pipelinekt.core.When
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class Environment(val name: Var.Environment, val value: Var.Literal.Str) : When {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("environment name: ${name.toGroovy()}, value: ${value.toGroovy()}")
    }
}
