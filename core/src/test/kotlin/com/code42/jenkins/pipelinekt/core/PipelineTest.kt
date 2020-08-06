package com.code42.jenkins.pipelinekt.core

import com.code42.jenkins.pipelinekt.core.method.PipelineMethod
import com.code42.jenkins.pipelinekt.core.stage.Stage
import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.core.writer.GroovyScript
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter
import kotlin.test.assertEquals
import org.junit.Test

class PipelineTest : GroovyScriptTest() {
    val libraries = listOf(
            PipelineLibrary("lib", "version")
    )
    val rawPreamble = "some preamble code"
    val preamble = object : GroovyScript {
        override fun toGroovy(writer: GroovyWriter) {
            writer.writeln(rawPreamble)
        }
    }
    val agentRaw = "an agent yo!"
    val agent = object : Agent {
        override fun toGroovy(writer: GroovyWriter) {
            writer.writeln(agentRaw)
        }
    }

    val toolRaws = listOf("tool1", "tool2")
    val tools: List<Tool> = toolRaws.map {
        object : Tool {
            override fun toGroovy(writer: GroovyWriter) {
                writer.writeln(it)
            }
        }
    }

    val optionsRaw = listOf("option1", "option2")
    val options: List<Option> = optionsRaw.map {
        object : Option {
            override fun toGroovy(writer: GroovyWriter) {
                writer.writeln(it)
            }
        }
    }

    val triggersRaw = listOf("trigger1", "trigger2")
    val triggers: List<Trigger> = triggersRaw.map {
        object : Trigger {
            override fun toGroovy(writer: GroovyWriter) {
                writer.writeln(it)
            }
        }
    }

    val parametersRaw = listOf("parameters1", "parameters2")
    val parameters: List<Parameter> = parametersRaw.map {
        object : Parameter {
            override val name: Var.Literal.Str
                get() = it.strSingle()

            override fun toXml(): String = it

            override fun toGroovy(writer: GroovyWriter) {
                writer.writeln(it)
            }
        }
    }

    fun String.toStep(): Step {
        return object : SingletonStep, DeclarativeStep {
            override fun toGroovy(writer: GroovyWriter) {
                writer.writeln(this@toStep)
            }
        }
    }

    val stagesRaw = listOf("stage1", "stage2")
    val stages = stagesRaw.map {
        Stage.Steps(
                it.strSingle(),
                object : SingletonStep, DeclarativeStep {
                    override fun toGroovy(writer: GroovyWriter) {
                        writer.writeln(it)
                    }
                }
        )
    }

    val methodsRaw = listOf("method1", "method2")
    val methods = methodsRaw.map {
        PipelineMethod(it, it.toStep())
    }

    val postRaw = "post"
    val post = Post(always = postRaw.toStep())
    val pipeline = Pipeline(
            libraries = listOf(PipelineLibrary("lib", "version")),
            preamble = preamble,
            agent = agent,
            tools = tools,
            options = options,
            triggers = triggers,
            parameters = parameters,
            stages = stages,
            methods = methods,
            post = post
            )

    fun closure(name: String, innerValues: List<String>, depth: Int): String {
        return "${indentStr.repeat(depth)}$name {\n" +
                innerValues.map { "${indentStr.repeat(depth + 1)}$it" }.joinToString("\n") +
                "\n" +
                "${indentStr.repeat(depth)}}"
    }
    @Test
    fun shouldWriteToGrovy() {
        pipeline.toGroovy(writer)
        val expected = """${libraries.map { "@Library(\"${it.name}@${it.version}\") ${it.suffix}"}.joinToString("")}

$rawPreamble

pipeline {
${indentStr}$agentRaw
${closure("tools", toolRaws, 1)}
${closure("options", optionsRaw, 1)}
${closure("triggers", triggersRaw, 1)}
${closure("parameters", parametersRaw, 1)}
${indentStr}stages {
${stagesRaw.map { """${indentStr}${indentStr}stage('$it') {
${indentStr}${indentStr}${indentStr}steps {
${indentStr}${indentStr}${indentStr}${indentStr}$it
${indentStr}${indentStr}$indentStr}
${indentStr}$indentStr}"""
        }.joinToString("\n")}
$indentStr}
${indentStr}post {
${indentStr}${indentStr}always {
${indentStr}${indentStr}${indentStr}$postRaw
${indentStr}$indentStr}
$indentStr}
}
${methodsRaw.map { closure("def $it()", listOf(it), 0)}.joinToString("\n") }
"""

        assertEquals(expected, out.toString())
    }
}
