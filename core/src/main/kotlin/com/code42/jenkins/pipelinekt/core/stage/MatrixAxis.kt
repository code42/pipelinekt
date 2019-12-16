package com.code42.jenkins.pipelinekt.core.stage

import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyScript
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class MatrixAxis(
    val name: Var.Literal.Str,
    val values: List<Var.Literal.Str>
) : GroovyScript {
    override fun toGroovy(writer: GroovyWriter) {
        writer.closure("axis") {
            it.writeln("name ${name.toGroovy()}")
            it.writeln("values ${values.map { it.toGroovy() }.joinToString(", ")}")
        }
    }
}
