package com.code42.jenkins.pipelinekt.dsl.step.declarative

import com.code42.jenkins.pipelinekt.core.buildParameter.BuildParameterValue
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.vars.ext.parameter
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.buildParameter.BooleanBuildParameterValue
import com.code42.jenkins.pipelinekt.internal.buildParameter.StringBuildParameterValue
import com.code42.jenkins.pipelinekt.internal.step.declarative.Build

fun DslContext<Step>.build(jobName: String, parameters: List<BuildParameterValue>, wait: Boolean) {
    build(jobName.strDouble(), parameters, wait.boolVar())
}

fun DslContext<Step>.build(jobName: Var, parameters: List<BuildParameterValue>, wait: Var.Literal.Bool) {
    add(Build(jobName, parameters, wait))
}

// Parameter Values

// // Boolean Parameter Values
fun booleanBuildParameterValue(name: Var.Literal.Str, value: Var): BuildParameterValue {
    return BooleanBuildParameterValue(name, value)
}

fun booleanBuildParameterValue(name: String, value: Var): BuildParameterValue {
    return booleanBuildParameterValue(name.strDouble(), value)
}

fun booleanBuildParameterValue(name: String, value: Boolean): BuildParameterValue {
    return booleanBuildParameterValue(name.strDouble(), value.boolVar())
}

fun transitiveBooleanBuildParameterValue(name: String): BuildParameterValue {
    return booleanBuildParameterValue(name.strDouble(), name.parameter())
}

// // String Parameter Values
fun stringBuildParameterValue(name: Var.Literal.Str, value: Var): BuildParameterValue {
    return StringBuildParameterValue(name, value)
}

fun stringBuildParameterValue(name: String, value: Var): BuildParameterValue {
    return stringBuildParameterValue(name.strDouble(), value)
}

fun stringBuildParameterValue(name: String, value: String): BuildParameterValue {
    return stringBuildParameterValue(name.strDouble(), value.strDouble())
}

fun transitiveStringBuildParameterValue(name: String): BuildParameterValue {
    return stringBuildParameterValue(name.strDouble(), name.parameter())
}
