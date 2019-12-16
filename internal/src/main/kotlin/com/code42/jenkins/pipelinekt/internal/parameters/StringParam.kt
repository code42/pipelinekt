package com.code42.jenkins.pipelinekt.internal.parameters

import com.code42.jenkins.pipelinekt.core.Parameter
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * String Param
 */
data class StringParam(
    val defaultValue: Var.Literal.Str,
    val description: Var.Literal.Str,
    override val name: Var.Literal.Str
) : Parameter {
    override fun toXml(): String {
        return """
            <hudson.model.StringParameterDefinition>
               <name>${name.value}</name>
                <description>${description.value}</description>
                <defaultValue>${defaultValue.value}</defaultValue>
                <trim>false</trim>
            </hudson.model.StringParameterDefinition>
        """.trimIndent()
    }

    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("string(defaultValue: ${defaultValue.toGroovy()}, description: ${description.toGroovy()}, name: ${name.toGroovy()})")
    }
}
