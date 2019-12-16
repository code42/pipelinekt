package com.code42.jenkins.pipelinekt.dsl.step.scripted

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.internal.step.scripted.Docker

object docker {
    fun build(image: Var.Literal.Str, args: Var.Literal.Str = ".".strSingle()): Docker.Build = Docker.Build(image, args)
    fun image(id: Var.Literal.Str): Docker.Image = Docker.Image(id)
    fun withRegistry(url: Var.Literal.Str, credentialsId: Var.Literal.Str? = null, steps: Step): Docker.WithRegistry = Docker.WithRegistry(url, credentialsId, steps)
    fun withServer(url: Var.Literal.Str, credentialsId: Var.Literal.Str? = null, steps: Step): Docker.WithServer = Docker.WithServer(url, credentialsId, steps)
    fun withTool(toolName: Var.Literal.Str, steps: Step): Docker.WithTool = Docker.WithTool(toolName, steps)

    fun build(image: String, args: String = "."): Docker.Build = Docker.Build(image.strDouble(), args.strDouble())
    fun image(id: String): Docker.Image = Docker.Image(id.strDouble())
    fun withRegistry(url: String, credentialsId: String? = null, steps: Step): Docker.WithRegistry = Docker.WithRegistry(url.strDouble(), credentialsId?.let { it.strDouble() }, steps)
    fun withServer(url: String, credentialsId: String? = null, steps: Step): Docker.WithServer = Docker.WithServer(url.strDouble(), credentialsId?.let { it.strDouble() }, steps)
    fun withTool(toolName: String, steps: Step): Docker.WithTool = Docker.WithTool(toolName.strDouble(), steps)
}

fun Docker.ImageOps.inside(args: String = "", steps: Step): Step = this.inside(args.strDouble(), steps)
fun Docker.ImageOps.withRun(args: String = "", command: String = "", steps: Step): Step = this.withRun(args.strDouble(), command.strDouble(), steps)
fun Docker.ImageOps.run(args: String = "", command: String = ""): Step = this.run(args.strDouble(), command.strDouble())
fun Docker.ImageOps.tag(tagName: String? = null, force: Boolean = true) = this.tag(tagName?.let { it.strDouble() }, force.boolVar())
fun Docker.ImageOps.push(tagName: String? = null, force: Boolean = true) = this.push(tagName?.let { it.strDouble() }, force.boolVar())
