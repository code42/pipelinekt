package com.code42.jenkins.pipelinekt.internal.parameters

import com.code42.jenkins.pipelinekt.core.Parameter
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class Choice(
    override val name: Var.Literal.Str,
    val choices: List<Var.Literal.Str>,
    val description: Var.Literal.Str
) : Parameter {
    override fun toXml(): String {
        return """
            <hudson.model.ChoiceParameterDefinition>
                <name>choice</name>
                <description/>
                <choices class="java.util.Arrays${'$'}ArrayList">
                    <a class="string-array">
                        ${choices.map { "<string>${it.value}</string>" }}
                    </a>
                </choices>
            </hudson.model.ChoiceParameterDefinition>
        """.trimIndent()
    }

    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("choice(")
        writer.writeln("${writer.indentStr}name: ${name.toGroovy()},")
        writer.writeln("${writer.indentStr}description: ${description.toGroovy()},")
        writer.writeln("${writer.indentStr}choices: [")
        choices.take(choices.size - 1).forEach {
            writer.writeln("${writer.indentStr.repeat(2)}${it.toGroovy()},")
        }
        choices.last()?.let {
            writer.writeln("${writer.indentStr.repeat(2)}${it.toGroovy()}")
        }
        writer.writeln("${writer.indentStr}])")
    }
}
