package com.code42.jenkins.pipelinekt.internal.`when`

import com.code42.jenkins.pipelinekt.core.When
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class Literal(val codeBlock: String) : When {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln(codeBlock)
    }
}
