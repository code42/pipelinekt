package com.code42.jenkins.pipelinekt.internal.parameters

import com.code42.jenkins.pipelinekt.core.Parameter
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class File(override val name: Var.Literal.Str, val description: Var.Literal.Str) : Parameter {
    override fun toXml(): String {
        return """
            <hudson.model.FileParameterDefinition>
                <name>${name.value}</name>
                <description>${description.value}</description>
            </hudson.model.FileParameterDefinition>
        """.trimIndent()
    }

    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("file(description: ${description.toGroovy()}, name: ${name.toGroovy()})")
    }
}
