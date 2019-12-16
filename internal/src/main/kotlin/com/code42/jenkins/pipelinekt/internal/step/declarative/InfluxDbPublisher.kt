package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class InfluxDbPublisher(
    val target: Var,
    val customData: Map<String, Var> = emptyMap(),
    val customDataTags: Map<String, Var.Literal.Str> = emptyMap(),
    val customDataMap: Map<String, Map<String, Var>> = emptyMap(),
    val customDataMapTags: Map<String, Map<String, Var.Literal.Str>> = emptyMap(),
    val customPrefix: Var.Literal.Str? = null
) : DeclarativeStep, SingletonStep {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("step([")
        writer.inner().let { indentedWriter ->
            indentedWriter.writeln("\$class: 'InfluxDbPublisher',")
            indentedWriter.writeln("target: ${target.toGroovy()},")
            indentedWriter.writeln("selectedTarget: ${target.toGroovy()},")
            indentedWriter.writeln("customPrefix: ${ customPrefix?.let { it.toGroovy() } },")
            indentedWriter.writeln("customData: ${groovyString(customData, writer.indentStr)},")
            indentedWriter.writeln("customDataTags: ${groovyString(customDataTags, writer.indentStr)},")
            indentedWriter.writeln("customDataMap: ${groovyStringForNestedMap(customDataMap, writer.indentStr)},")
            indentedWriter.writeln("customDataMapTags: ${groovyStringForNestedMap(customDataMapTags, writer.indentStr)}")
        }
        writer.writeln("])")
    }

    fun groovyString(data: Map<String, Var>, indent: String): String {
        if (data.isEmpty()) {
            return "[:]"
        }
        return "[\n${data.map { (k, v) -> "$indent$k: ${v.toGroovy()}"}.joinToString(",\n")} ]"
    }

    fun groovyStringForNestedMap(data: Map<String, Map<String, out Var>>, indent: String): String {
        if (data.isEmpty()) {
            return "[:]"
        } else {
            return "[\n${data.map { (k, v) -> "$indent$k: ${groovyString(v, indent.repeat(2))}"}.joinToString(",\n")} ]"
        }
    }
}
