package com.code42.jenkins.pipelinekt.dsl.step.scripted

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.writer.ext.toStep
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.scripted.Node

fun DslContext<Step>.node(label: String, steps: DslContext<Step>.() -> Unit) = node(label.strDouble(), steps)

fun DslContext<Step>.node(label: Var.Literal.Str, steps: DslContext<Step>.() -> Unit) {
    add(Node(label, DslContext.into(steps).toStep()))
}
