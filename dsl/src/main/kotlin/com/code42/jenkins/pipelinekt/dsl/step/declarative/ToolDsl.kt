package com.code42.jenkins.pipelinekt.dsl.step.declarative

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.declarative.Tool

fun DslContext<Step>.tool(name: String, type: String) =
        tool(name.strDouble(), type.strDouble())

fun DslContext<Step>.tool(name: Var, type: Var) = add(Tool(name, type))
