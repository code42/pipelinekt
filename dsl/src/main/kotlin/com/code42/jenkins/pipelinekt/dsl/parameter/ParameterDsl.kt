package com.code42.jenkins.pipelinekt.dsl.parameter

import com.code42.jenkins.pipelinekt.core.Parameter
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.parameters.BooleanParam
import com.code42.jenkins.pipelinekt.internal.parameters.Choice
import com.code42.jenkins.pipelinekt.internal.parameters.Password
import com.code42.jenkins.pipelinekt.internal.parameters.StringParam
import com.code42.jenkins.pipelinekt.internal.parameters.Text

fun DslContext<Parameter>.string(name: String, defaultValue: String, description: String) {
    string(name.strDouble(), defaultValue.strDouble(), description.strDouble())
}

fun DslContext<Parameter>.string(name: Var.Literal.Str, defaultValue: Var.Literal.Str, description: Var.Literal.Str) {
    add(StringParam(defaultValue, description, name))
}

fun DslContext<Parameter>.text(name: String, defaultValue: String, description: String) {
    text(name.strDouble(), defaultValue.strDouble(), description.strDouble())
}

fun DslContext<Parameter>.text(name: Var.Literal.Str, defaultValue: Var.Literal.Str, description: Var.Literal.Str) {
    add(Text(defaultValue, description, name))
}

fun DslContext<Parameter>.choice(name: String, choices: List<String>, description: String) {
    choice(name.strDouble(), choices.map { it.strDouble() }, description.strDouble())
}

fun DslContext<Parameter>.choice(name: Var.Literal.Str, choices: List<Var.Literal.Str>, description: Var.Literal.Str) {
    add(Choice(name, choices, description))
}

fun DslContext<Parameter>.booleanParam(name: String, defaultValue: Boolean, description: String) {
    booleanParam(name.strDouble(), defaultValue, description.strDouble())
}

fun DslContext<Parameter>.booleanParam(name: Var.Literal.Str, defaultValue: Boolean, description: Var.Literal.Str) {
    add(BooleanParam(defaultValue, description, name))
}

fun DslContext<Parameter>.password(name: String, defaultValue: String, description: String) {
    password(name.strDouble(), defaultValue.strDouble(), description.strDouble())
}

fun DslContext<Parameter>.password(name: Var.Literal.Str, defaultValue: Var.Literal.Str, description: Var.Literal.Str) {
    add(Password(defaultValue, description, name))
}
