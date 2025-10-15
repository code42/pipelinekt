package com.code42.jenkins.pipelinekt.dsl.step.scripted

import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.core.writer.ext.toStep
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.internal.step.scripted.Ws

/**
 * Executes steps in a custom workspace directory
 * @param path The path to use as the workspace directory
 * @param stepBlock The steps to execute in the workspace
 */
fun DslContext<Step>.ws(path: String, stepBlock: DslContext<Step>.() -> Unit) {
    add(Ws(path.strSingle(), DslContext.into(stepBlock).toStep()))
}

/**
 * Executes steps in a custom workspace directory
 * @param path The path to use as the workspace directory
 * @param stepBlock The steps to execute in the workspace
 */
fun DslContext<Step>.ws(path: Var.Literal.Str, stepBlock: DslContext<Step>.() -> Unit) {
    add(Ws(path, DslContext.into(stepBlock).toStep()))
}