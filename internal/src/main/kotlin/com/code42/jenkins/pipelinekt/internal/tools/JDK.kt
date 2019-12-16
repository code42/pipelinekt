package com.code42.jenkins.pipelinekt.internal.tools

import com.code42.jenkins.pipelinekt.core.Tool
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class JDK(val jdk: Var.Literal.Str) : Tool {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("jdk ${jdk.toGroovy()}")
    }
}
