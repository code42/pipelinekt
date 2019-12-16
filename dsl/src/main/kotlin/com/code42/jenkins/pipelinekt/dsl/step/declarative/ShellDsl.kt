package com.code42.jenkins.pipelinekt.dsl.step.declarative

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.declarative.Bat
import com.code42.jenkins.pipelinekt.internal.step.declarative.Sh

fun DslContext<Step>.sh(script: String, returnStdout: Boolean = false, label: String? = null) =
        sh(script = script.strDouble(), returnStdout = returnStdout.boolVar(), label = label?.strDouble())

fun DslContext<Step>.sh(script: Var.Literal.Str, returnStdout: Var.Literal.Bool = false.boolVar(), label: Var.Literal.Str? = null) =
        add(Sh(script = script, returnStdout = returnStdout, label = label))

fun DslContext<Step>.bat(script: String, returnStdout: Boolean = false, label: String? = null) =
        bat(script = script.strDouble(), returnStdout = returnStdout.boolVar(), label = label?.strDouble())

fun DslContext<Step>.bat(script: Var.Literal.Str, returnStdout: Var.Literal.Bool = false.boolVar(), label: Var.Literal.Str? = null) =
        add(Bat(script = script, returnStdout = returnStdout, label = label))
