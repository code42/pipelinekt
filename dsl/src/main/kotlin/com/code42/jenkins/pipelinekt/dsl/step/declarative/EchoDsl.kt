package com.code42.jenkins.pipelinekt.dsl.step.declarative

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.declarative.Echo

fun DslContext<Step>.echo(string: String) =
        echo(string.strDouble())

fun DslContext<Step>.echo(string: Var.Literal.Str) =
        add(Echo(string))
