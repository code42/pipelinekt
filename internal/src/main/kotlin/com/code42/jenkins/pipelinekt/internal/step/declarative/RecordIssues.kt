package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.issues.RecordIssuesTool
import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class RecordIssues(val aggregatingResults: Var.Literal.Bool = false.boolVar(), val tool: RecordIssuesTool) : DeclarativeStep, SingletonStep {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("recordIssues enabledForFailure: true, aggregatingResults: ${aggregatingResults.toGroovy()}, tool: ${tool.toGroovy()}")
    }
}
