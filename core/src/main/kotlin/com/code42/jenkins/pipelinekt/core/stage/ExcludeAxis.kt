package com.code42.jenkins.pipelinekt.core.stage

import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyScript
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

sealed class ExcludeAxis : GroovyScript {
    abstract val name: Var.Literal.Str

    data class Values(override val name: Var.Literal.Str, val values: List<Var.Literal.Str>) : ExcludeAxis() {
        override fun toGroovy(writer: GroovyWriter) {
            writer.closure("axis") {
                it.writeln("name ${name.toGroovy()}")
                it.writeln("values ${values.map { it.toGroovy() }.joinToString(", ")}")
            }
        }
    }

    data class NotValues(override val name: Var.Literal.Str, val notValues: List<Var.Literal.Str>) : ExcludeAxis() {
        override fun toGroovy(writer: GroovyWriter) {
            writer.closure("axis") {
                it.writeln("name ${name.toGroovy()}")
                it.writeln("notValues ${notValues.map { it.toGroovy() }.joinToString(", ")}")
            }
        }
    }
}
