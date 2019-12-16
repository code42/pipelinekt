package com.code42.jenkins.pipelinekt.internal.`when`

import com.code42.jenkins.pipelinekt.core.When
import com.code42.jenkins.pipelinekt.core.conditional.BooleanStatement
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class Expression(val statement: BooleanStatement) : When {
    override fun toGroovy(writer: GroovyWriter) {
        writer.closure("expression") { innerWriter ->
            innerWriter.writeln(statement.toGroovy())
        }
    }
}
