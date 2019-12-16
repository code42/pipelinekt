package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.artifactory.RTSpec
import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.multline
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter
import com.google.gson.GsonBuilder

abstract class RTBase : DeclarativeStep, SingletonStep {
    abstract val rtCommand: String
    abstract val serverID: Var.Literal.Str
    abstract val buildName: Var.Literal.Str?
    abstract val buildNumber: Var.Literal.Str?
    abstract val failNoOp: Var.Literal.Bool
    abstract val spec: RTSpec?
    abstract val specPath: Var.Literal.Str?

    fun rtUploadOrDownloadToGroovy(writer: GroovyWriter) {
        val gson = GsonBuilder().setPrettyPrinting().create()
        val specJSON: String = gson.toJson(spec)

        val rtContent = listOf("${writer.indentStr}serverID: ${serverID.toGroovy()}",
                (buildName?.let { "buildName: ${it.toGroovy()}" }),
                (buildNumber?.let { "buildNumber: ${it.toGroovy()}" }),
                (failNoOp?.let { "faliNoOp: ${it.toGroovy()}" }),
                (spec?.let { "spec: ${specJSON.multline().toGroovy()}" }),
                (specPath?.let { "specPath: ${it.toGroovy()}" }))
                .filterNotNull().joinToString(",\n${writer.indentStr}")
        writer.writeln("$rtCommand (\n${rtContent}\n)")
    }
}
