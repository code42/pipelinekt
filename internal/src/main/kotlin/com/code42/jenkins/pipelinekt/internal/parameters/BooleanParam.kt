package com.code42.jenkins.pipelinekt.internal.parameters

import com.code42.jenkins.pipelinekt.core.Parameter
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * Boolean Pipeline Param
 */
data class BooleanParam(
    val defaultValue: kotlin.Boolean,
    val description: Var.Literal.Str,
    override val name: Var.Literal.Str
) : Parameter {
    override fun toXml(): String {
        return """
            <hudson.model.BooleanParameterDefinition>
                <name>${name.value}</name>
                <description>${description.value}</description>
                <defaultValue>$defaultValue</defaultValue>
            </hudson.model.BooleanParameterDefinition>
        """.trimIndent()
    }

    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("booleanParam(defaultValue: $defaultValue, description: ${description.toGroovy()}, name: ${name.toGroovy()})")
    }
}
