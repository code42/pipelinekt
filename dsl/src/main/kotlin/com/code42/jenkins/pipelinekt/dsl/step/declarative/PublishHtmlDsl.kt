package com.code42.jenkins.pipelinekt.dsl.step.declarative

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.declarative.PublishHtml

fun DslContext<Step>.publishHtml(
    reportDir: String,
    reportFiles: String,
    reportName: String,
    allowMissing: Boolean = true,
    alwaysLinkToLastBuild: Boolean = true,
    keepAll: Boolean = true
) =
        publishHtml(reportDir = reportDir.strDouble(),
                reportFiles = reportFiles.strDouble(),
                reportName = reportName.strDouble(),
                allowMissing = allowMissing.boolVar(),
                alwaysLinkToLastBuild = alwaysLinkToLastBuild.boolVar(),
                keepAll = keepAll.boolVar())

fun DslContext<Step>.publishHtml(
    reportDir: Var.Literal.Str,
    reportFiles: Var.Literal.Str,
    reportName: Var.Literal.Str,
    allowMissing: Var.Literal.Bool = true.boolVar(),
    alwaysLinkToLastBuild: Var.Literal.Bool = true.boolVar(),
    keepAll: Var.Literal.Bool = true.boolVar()
) =
        add(PublishHtml(reportDir = reportDir, reportFiles = reportFiles, reportName = reportName, allowMissing = allowMissing, alwaysLinkToLastBuild = alwaysLinkToLastBuild, keepAll = keepAll))
