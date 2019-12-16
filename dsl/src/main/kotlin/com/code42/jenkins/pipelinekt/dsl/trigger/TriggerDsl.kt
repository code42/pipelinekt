package com.code42.jenkins.pipelinekt.dsl.trigger

import com.code42.jenkins.pipelinekt.core.Trigger
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.triggers.Cron
import com.code42.jenkins.pipelinekt.internal.triggers.PollScm

fun DslContext<Trigger>.pollScm(pollInterval: String = "H * * * *") {
    pollScm(pollInterval.strDouble())
}

fun DslContext<Trigger>.pollScm(pollInterval: Var.Literal.Str = "H * * * *".strSingle()) {
    add(PollScm(pollInterval))
}

fun DslContext<Trigger>.cron(pollInterval: String = "H * * * *") {
    cron(pollInterval.strDouble())
}

fun DslContext<Trigger>.cron(pollInterval: Var.Literal.Str = "H * * * *".strSingle()) {
    add(Cron(pollInterval))
}
