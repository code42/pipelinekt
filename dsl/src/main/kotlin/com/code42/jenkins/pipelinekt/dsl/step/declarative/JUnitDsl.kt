package com.code42.jenkins.pipelinekt.dsl.step.declarative

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.declarative.JUnit

fun DslContext<Step>.junit(testResults: String) =
        junit(testResults = testResults.strDouble(), false)

fun DslContext<Step>.junit(testResults: String, allowEmptyResults: Boolean) =
        junit(testResults = testResults.strDouble(), allowEmptyResults)

fun DslContext<Step>.junit(testResults: Var.Literal.Str) =
        add(JUnit(testResults = testResults, false))
fun DslContext<Step>.junit(testResults: Var.Literal.Str, allowEmptyResults: Boolean) =
        add(JUnit(testResults = testResults, allowEmptyResults))
