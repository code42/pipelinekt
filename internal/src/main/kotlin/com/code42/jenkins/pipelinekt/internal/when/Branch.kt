package com.code42.jenkins.pipelinekt.internal.`when`

import com.code42.jenkins.pipelinekt.core.Comparator
import com.code42.jenkins.pipelinekt.core.When
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

sealed class Branch : When {
    data class Name(val name: Var.Literal.Str) : Branch() {
        override fun toGroovy(writer: GroovyWriter) {
            writer.writeln("branch ${name.toGroovy()}")
        }
    }

    data class Pattern(val pattern: Var.Literal.Str, val comparator: Comparator) : Branch() {
        override fun toGroovy(writer: GroovyWriter) {
            writer.writeln("branch pattern: ${pattern.toGroovy()}, comparator: ${comparator.toGroovy()}")
        }
    }
}
