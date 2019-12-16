package com.code42.jenkins.pipelinekt.dsl.step.scripted

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.vars.ext.groovyVariable
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.core.writer.ext.toStep
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.scripted.Docker

data class DockerVar(val name: String, val context: DslContext<Step>) : Var.External() {
    override fun toGroovy(): String {
        return name
    }

    fun inside(args: String = "", steps: DslContext<Step>.() -> Unit) {
        context.literal(this.name)
        context.add(Docker.ImageOps.Inside(args.strDouble(), DslContext.into(steps).toStep()))
    }

    fun withRun(args: String = "", command: String = "", containerVariable: Var.Variable = "container".groovyVariable(), steps: DslContext<Step>.() -> Unit) {
        context.literal(this.name)
        context.add(Docker.ImageOps.WithRun(args.strDouble(), command.strDouble(), DslContext.into(steps).toStep(), containerVariable))
    }

    fun withRun(args: Literal.Str, command: Literal.Str?, containerVariable: Var.Variable, steps: DslContext<Step>.() -> Unit) {
        context.literal(this.name)
        context.add(Docker.ImageOps.WithRun(args, command, DslContext.into(steps).toStep(), containerVariable))
    }

    fun run(args: String = "", command: String = "") {
        context.literal(this.name)
        context.add(Docker.ImageOps.Run(args.strDouble(), command.strDouble()))
    }
    fun tag(tagName: String? = null, force: Boolean = true) {
        context.literal(this.name)
        context.add(Docker.ImageOps.Tag(tagName?.let { it.strDouble() }, force.boolVar()))
    }
    fun push(tagName: String? = null, force: Boolean = true) {
        context.literal(this.name)
        context.add(Docker.ImageOps.Push(tagName?.let { it.strDouble() }, force.boolVar()))
    }
}

private fun DslContext<Step>.dockerVar(step: Step): DockerVar =
        def { add(step) }.let { DockerVar(it.name, this) }

fun DslContext<Step>.dockerBuild(image: Var.Literal.Str, args: Var.Literal.Str = ".".strSingle()): DockerVar =
        dockerVar(Docker.Build(image, args))

fun DslContext<Step>.dockerImage(id: Var.Literal.Str): DockerVar =
        dockerVar(Docker.Image(id))

fun DslContext<Step>.withDockerRegistry(
    url: Var.Literal.Str,
    credentialsId: Var.Literal.Str? = null,
    steps: DslContext<Step>.() -> Unit
) {
    add(Docker.WithRegistry(url, credentialsId, DslContext.into(steps).toStep()))
}
fun DslContext<Step>.withDockerServer(
    url: Var.Literal.Str,
    credentialsId: Var.Literal.Str? = null,
    steps: DslContext<Step>.() -> Unit
) {
    add(Docker.WithServer(url, credentialsId, DslContext.into(steps).toStep()))
}
fun DslContext<Step>.withDockerTool(toolName: Var.Literal.Str, steps: DslContext<Step>.() -> Unit) {
    add(Docker.WithTool(toolName, DslContext.into(steps).toStep()))
}

fun DslContext<Step>.dockerBuild(image: String, args: String = "."): DockerVar =
        dockerVar(Docker.Build(image.strDouble(), args.strDouble()))

fun DslContext<Step>.dockerImage(id: String): DockerVar =
        dockerVar(Docker.Image(id.strDouble()))

fun DslContext<Step>.withDockerRegistry(
    url: String,
    credentialsId: String? = null,
    steps: DslContext<Step>.() -> Unit
) {
    add(Docker.WithRegistry(url.strDouble(), credentialsId?.let { it.strDouble() }, DslContext.into(steps).toStep()))
}
fun DslContext<Step>.withDockerServer(
    url: String,
    credentialsId: String? = null,
    steps: DslContext<Step>.() -> Unit
) {
    add(Docker.WithServer(url.strDouble(), credentialsId?.let { it.strDouble() }, DslContext.into(steps).toStep()))
}
fun DslContext<Step>.withDockerTool(
    toolName: String,
    steps: DslContext<Step>.() -> Unit
) {
    add(Docker.WithTool(toolName.strDouble(), DslContext.into(steps).toStep()))
}
