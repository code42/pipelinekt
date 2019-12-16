package com.code42.jenkins.pipelinekt.dsl.step.declarative

import com.code42.jenkins.pipelinekt.core.artifactory.RTSpec
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.declarative.RTDownload
import com.code42.jenkins.pipelinekt.internal.step.declarative.RTUpload

fun DslContext<Step>.rtUpload(
    serverId: String,
    buildName: String? = null,
    buildNumber: String? = null,
    failNoOp: Boolean = false,
    spec: RTSpec? = null,
    specPath: String? = null
) {
    rtUpload(serverId.strDouble(), buildName?.strDouble(), buildNumber?.strDouble(), failNoOp.boolVar(), spec, specPath?.strDouble())
}

fun DslContext<Step>.rtUpload(
    serverId: Var.Literal.Str,
    buildName: Var.Literal.Str? = null,
    buildNumber: Var.Literal.Str? = null,
    failNoOp: Var.Literal.Bool = false.boolVar(),
    spec: RTSpec? = null,
    specPath: Var.Literal.Str? = null
) {
    add(RTUpload(serverId, buildName, buildNumber, failNoOp, spec, specPath))
}

fun DslContext<Step>.rtDownload(
    serverId: String,
    buildName: String? = null,
    buildNumber: String? = null,
    failNoOp: Boolean = false,
    spec: RTSpec? = null,
    specPath: String? = null
) {
    rtDownload(serverId.strDouble(), buildName?.strDouble(), buildNumber?.strDouble(), failNoOp.boolVar(), spec, specPath?.strDouble())
}

fun DslContext<Step>.rtDownload(
    serverId: Var.Literal.Str,
    buildName: Var.Literal.Str? = null,
    buildNumber: Var.Literal.Str? = null,
    failNoOp: Var.Literal.Bool = false.boolVar(),
    spec: RTSpec? = null,
    specPath: Var.Literal.Str? = null
) {
    add(RTDownload(serverId, buildName, buildNumber, failNoOp, spec, specPath))
}
