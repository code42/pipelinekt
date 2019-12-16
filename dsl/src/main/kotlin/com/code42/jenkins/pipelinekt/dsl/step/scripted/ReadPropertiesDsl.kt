package com.code42.jenkins.pipelinekt.dsl.step.scripted

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.scripted.ReadProperties

fun DslContext<Step>.readProperties(file: String) {
    readProperties(file.strDouble())
}

fun DslContext<Step>.readProperties(file: Var) {
    add(ReadProperties(file))
}
