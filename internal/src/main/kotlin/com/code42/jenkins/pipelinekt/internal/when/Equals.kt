package com.code42.jenkins.pipelinekt.internal.`when`

import com.code42.jenkins.pipelinekt.core.When
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class Equals(val expected: Var, val actual: Var) : When {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("equals expected: ${expected.toGroovy()}, actual: ${actual.toGroovy()}")
    }
}
