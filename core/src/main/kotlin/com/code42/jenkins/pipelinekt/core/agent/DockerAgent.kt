package com.code42.jenkins.pipelinekt.core.agent

import com.code42.jenkins.pipelinekt.core.Agent
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

sealed class DockerAgent : Agent {
    abstract val args: Var.Literal.Str?
    abstract val label: Var.Literal.Str?
    abstract val customWorkspace: Var.Literal.Str?
    abstract val registryUrl: Var.Literal.Str?
    abstract val registryCredentialsId: Var.Literal.Str?
    abstract val reuseNode: Var.Literal.Bool?

    data class Image(
        val image: Var.Literal.Str,
        override val args: Var.Literal.Str? = null,
        override val label: Var.Literal.Str? = null,
        override val customWorkspace: Var.Literal.Str? = null,
        override val registryUrl: Var.Literal.Str? = null,
        override val registryCredentialsId: Var.Literal.Str? = null,
        override val reuseNode: Var.Literal.Bool? = null
    ) : DockerAgent() {
        override fun toGroovy(writer: GroovyWriter) {
            writer.closure("agent") { writer ->
                writer.closure("docker") { writer ->
                    writer.writeln("image ${image.toGroovy()}")
                    args?.let { writer.writeln("args ${it.toGroovy()}") }
                    label?.let { writer.writeln("label ${it.toGroovy()}") }
                    customWorkspace?.let { writer.writeln("customWorkspace ${it.toGroovy()}") }
                    registryUrl?.let { writer.writeln("registryUrl ${it.toGroovy()}") }
                    registryCredentialsId?.let { writer.writeln("registryCredentialsId ${it.toGroovy()}") }
                    reuseNode?.let { writer.writeln("reuseNode ${it.toGroovy()}") }
                }
            }
        }
    }

    data class File(
        val filename: Var.Literal.Str,
        val dir: Var.Literal.Str? = null,
        val additionalBuildArgs: Var.Literal.Str? = null,
        override val args: Var.Literal.Str? = null,
        override val label: Var.Literal.Str? = null,
        override val customWorkspace: Var.Literal.Str? = null,
        override val registryUrl: Var.Literal.Str? = null,
        override val registryCredentialsId: Var.Literal.Str? = null,
        override val reuseNode: Var.Literal.Bool? = null
    ) : DockerAgent() {
        override fun toGroovy(writer: GroovyWriter) {
            writer.closure("agent") { writer ->
                writer.closure("dockerfile") { writer ->
                    writer.writeln("filename ${filename.toGroovy()}")
                    args?.let { writer.writeln("args ${it.toGroovy()}") }
                    additionalBuildArgs?.let { writer.writeln("additionalBuildArgs ${it.toGroovy()}") }
                    dir?.let { writer.writeln("dir ${it.toGroovy()}") }
                    label?.let { writer.writeln("label ${it.toGroovy()}") }
                    customWorkspace?.let { writer.writeln("customWorkspace ${it.toGroovy()}") }
                    registryUrl?.let { writer.writeln("registryUrl ${it.toGroovy()}") }
                    registryCredentialsId?.let { writer.writeln("registryCredentialsId ${it.toGroovy()}") }
                    reuseNode?.let { writer.writeln("reuseNode ${it.toGroovy()}") }
                }
            }
        }
    }
}
