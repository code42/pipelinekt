package com.code42.jenkins.pipelinekt.internal.agent

import com.code42.jenkins.pipelinekt.core.Agent
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class Label(val label: Var.Literal.Str) : Agent {
    override fun toGroovy(writer: GroovyWriter) {
        writer.closure("agent") { writer ->
            writer.writeln("label ${label.toGroovy()}")
        }
    }
}
