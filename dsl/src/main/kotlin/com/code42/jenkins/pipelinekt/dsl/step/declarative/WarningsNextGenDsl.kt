package com.code42.jenkins.pipelinekt.dsl.step.declarative

import com.code42.jenkins.pipelinekt.core.issues.RecordIssuesTool
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.declarative.RecordIssues

fun DslContext<Step>.recordIssues(aggregateResults: Boolean, tool: RecordIssuesTool) =
        recordIssues(aggregateResults.boolVar(), tool)

fun DslContext<Step>.recordIssues(aggregateResults: Var.Literal.Bool = false.boolVar(), tool: RecordIssuesTool) = add(RecordIssues(aggregateResults, tool))

fun DslContext<Step>.checkStyle(pattern: String, id: String, name: String): RecordIssuesTool =
        RecordIssuesTool.CheckStyle(
                pattern = pattern.strDouble(),
                id = id.strDouble(),
                name = name.strDouble())
fun DslContext<Step>.spotBugs(pattern: String, id: String, name: String): RecordIssuesTool =
        RecordIssuesTool.Spotbugs(
                pattern = pattern.strDouble(),
                id = id.strDouble(),
                name = name.strDouble())
