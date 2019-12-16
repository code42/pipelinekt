package com.code42.jenkins.pipelinekt.internal.agent

import com.code42.jenkins.pipelinekt.core.Agent
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class Node(val label: Var.Literal.Str, val customWorkspace: Var.Literal.Str? = null) : Agent {
    override fun toGroovy(writer: GroovyWriter) {
        writer.closure("agent") { writer ->
            writer.closure("node") { writer ->
                writer.writeln("label ${label.toGroovy()}")
                customWorkspace?.let { writer.writeln("customWorkspace ${it.toGroovy()}") }
            }
        }
    }
}
