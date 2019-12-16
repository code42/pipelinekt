package com.code42.jenkins.pipelinekt.internal.option

import com.code42.jenkins.pipelinekt.core.option.BuildDiscarder
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class LogRotator(
    val numToKeep: Int,
    val daysToKeep: Int,
    val artifactsNumToKeep: Int,
    val artifactDaysToKeep: Int
) : BuildDiscarder {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("buildDiscarder(logRotator(")
        writer.writeln("${writer.indentStr}numToKeepStr: \"$numToKeep\",")
        writer.writeln("${writer.indentStr}daysToKeepStr: \"$daysToKeep\",")
        writer.writeln("${writer.indentStr}artifactNumToKeepStr: \"$artifactsNumToKeep\",")
        writer.writeln("${writer.indentStr}artifactDaysToKeepStr: \"$artifactDaysToKeep\"")
        writer.writeln("))")
    }
}
