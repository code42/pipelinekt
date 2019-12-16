package com.code42.jenkins.pipelinekt.dsl.tool

import com.code42.jenkins.pipelinekt.core.Tool
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.tools.JDK

fun DslContext<Tool>.jdk(name: String) {
    jdk(name.strDouble())
}

fun DslContext<Tool>.jdk(name: Var.Literal.Str) {
    add(JDK(name))
}
