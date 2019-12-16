package com.code42.jenkins.pipelinekt.dsl.step.declarative

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.writer.ext.toStep
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.declarative.Dir

fun DslContext<Step>.dir(name: String, steps: DslContext<Step>.() -> Unit) {
    dir(name.strDouble(), steps)
}

fun DslContext<Step>.dir(name: Var, steps: DslContext<Step>.() -> Unit) {
    add(Dir(name, DslContext.into(steps).toStep()))
}
