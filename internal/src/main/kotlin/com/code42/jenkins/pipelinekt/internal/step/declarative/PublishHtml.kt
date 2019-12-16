package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class PublishHtml(
    val reportDir: Var.Literal.Str,
    val reportFiles: Var.Literal.Str,
    val reportName: Var.Literal.Str,
    val allowMissing: Var.Literal.Bool = true.boolVar(),
    val alwaysLinkToLastBuild: Var.Literal.Bool = true.boolVar(),
    val keepAll: Var.Literal.Bool = true.boolVar()
) : DeclarativeStep, SingletonStep {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("publishHTML target: [")
        writer.inner().let { writer ->
            writer.writeln("allowMissing: ${allowMissing.toGroovy()},")
            writer.writeln("alwaysLinkToLastBuild: ${alwaysLinkToLastBuild.toGroovy()},")
            writer.writeln("keepAll: ${keepAll.toGroovy()},")
            writer.writeln("reportDir: ${reportDir.toGroovy()},")
            writer.writeln("reportFiles: ${reportFiles.toGroovy()},")
            writer.writeln("reportName: ${reportName.toGroovy()}")
        }
        writer.writeln("]")
    }
}
