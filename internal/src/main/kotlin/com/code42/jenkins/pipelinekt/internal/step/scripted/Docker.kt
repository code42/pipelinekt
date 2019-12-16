package com.code42.jenkins.pipelinekt.internal.step.scripted

import com.code42.jenkins.pipelinekt.core.step.NestedStep
import com.code42.jenkins.pipelinekt.core.step.ScriptedStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.vars.ext.groovyVariable
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

sealed class Docker : ScriptedStep {
    interface ImageOps : Step {
        fun inside(args: Var.Literal.Str = "".strSingle(), steps: Step): Step = this.andThen(Inside(args, steps))

        fun withRun(
            args: Var.Literal.Str = "".strSingle(),
            command: Var.Literal.Str? = null,
            steps: Step,
            containerVariable: Var.Variable = "container".groovyVariable()
        ): Step = this.andThen(WithRun(args, command, steps, containerVariable))

        fun run(
            args: Var.Literal.Str = "".strSingle(),
            command: Var.Literal.Str = "".strDouble()
        ): Step = this.andThen(Run(args, command))

        fun pull(): Step = this.andThen(Pull)

        fun tag(
            tagName: Var.Literal.Str? = null,
            force: Var.Literal.Bool = true.boolVar()
        ) = this.andThen(Tag(tagName, force))

        fun push(
            tagName: Var.Literal.Str? = null,
            force: Var.Literal.Bool = true.boolVar()
        ) = this.andThen(Push(tagName, force))

        data class Inside(
            val args: Var.Literal.Str = "".strSingle(),
            override val steps: Step
        ) : Docker(), NestedStep {
            override fun scriptedGroovy(writer: GroovyWriter) {
                writer.inner().closure(".inside(${args.toGroovy()})", steps::toGroovy)
            }
        }

        data class WithRun(
            val args: Var.Literal.Str = "".strSingle(),
            val command: Var.Literal.Str? = "".strDouble(),
            override val steps: Step,
            val containerVariable: Var.Variable = "container".groovyVariable()
        ) : Docker(), NestedStep {
            override fun scriptedGroovy(writer: GroovyWriter) {
                writer.inner().closure(
                        ".withRun(${args.toGroovy()}${command?.let{", ${it.toGroovy()}"} ?: ""})",
                        steps::toGroovy,
                        containerVariable)
            }
        }

        data class Run(
            val args: Var.Literal.Str = "".strSingle(),
            val command: Var.Literal.Str = "".strDouble()
        ) : Docker(), SingletonStep {
            override fun scriptedGroovy(writer: GroovyWriter) {
                writer.inner().writeln(".run(${args.toGroovy()}, ${command.toGroovy()})")
            }
        }

        object Pull : Docker(), SingletonStep {
            override fun scriptedGroovy(writer: GroovyWriter) {
                writer.inner().writeln(".pull()")
            }
        }

        data class Tag(
            val tagName: Var.Literal.Str? = null,
            val force: Var.Literal.Bool = true.boolVar()
        ) : Docker(), SingletonStep {
            override fun scriptedGroovy(writer: GroovyWriter) {
                writer.inner().writeln(".tag(${tagName?.let { "${it.toGroovy()}, ${force.toGroovy()}"} ?: ""})")
            }
        }

        data class Push(
            val tagName: Var.Literal.Str? = null,
            val force: Var.Literal.Bool = true.boolVar()
        ) : Docker(), SingletonStep {
            override fun scriptedGroovy(writer: GroovyWriter) {
                writer.inner().writeln(".push(${tagName?.let { "${it.toGroovy()}, ${force.toGroovy()}"} ?: ""})")
            }
        }
    }

    data class Build(
        val image: Var.Literal.Str,
        val args: Var.Literal.Str = ".".strSingle()
    ) : Docker(), ImageOps, SingletonStep {
        override fun scriptedGroovy(writer: GroovyWriter) {
            writer.writeln("docker.build(${image.toGroovy()}, ${args.toGroovy()})")
        }
    }

    data class Image(val id: Var.Literal.Str) : Docker(), ImageOps, SingletonStep {
        override fun scriptedGroovy(writer: GroovyWriter) {
            writer.writeln("docker.image(${id.toGroovy()})")
        }
    }

    data class WithRegistry(
        val url: Var.Literal.Str,
        val credentialsId: Var.Literal.Str? = null,
        override val steps: Step
    ) : Docker(), NestedStep {
        override fun scriptedGroovy(writer: GroovyWriter) {
            writer.closure(
                    "docker.withRegistry(${url.toGroovy()}, ${credentialsId?.let {it.toGroovy()} ?: "null"})",
                    steps::toGroovy)
        }
    }

    data class WithServer(
        val uri: Var.Literal.Str,
        val credentialsId: Var.Literal.Str? = null,
        override val steps: Step
    ) : Docker(), NestedStep {
        override fun scriptedGroovy(writer: GroovyWriter) {
            writer.closure(
                    "docker.withServer(${uri.toGroovy()}, ${credentialsId?.let { it.toGroovy() } ?: "null"})",
                    steps::toGroovy)
        }
    }

    // TODO verify this is correct
    data class WithTool(val toolName: Var.Literal.Str, override val steps: Step) : Docker(), NestedStep {
        override fun scriptedGroovy(writer: GroovyWriter) {
            writer.closure("docker.withTool(${toolName.toGroovy()})", steps::toGroovy)
        }
    }
}
