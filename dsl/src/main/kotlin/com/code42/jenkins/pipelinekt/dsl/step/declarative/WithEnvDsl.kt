package com.code42.jenkins.pipelinekt.dsl.step.declarative

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.ext.toStep
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.declarative.WithEnv

fun DslContext<Step>.withEnv(envs: Map<String, String>, steps: DslContext<Step>.() -> Unit) {
    add(WithEnv(envs, DslContext.into(steps).toStep()))
}

fun DslContext<Step>.withEnvVars(envs: Map<String, Var>, steps: DslContext<Step>.() -> Unit) {
    add(WithEnv.ofConstToVar(envs, DslContext.into(steps).toStep()))
}
