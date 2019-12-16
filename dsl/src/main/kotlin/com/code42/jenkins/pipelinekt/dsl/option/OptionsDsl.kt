package com.code42.jenkins.pipelinekt.dsl.option

import com.code42.jenkins.pipelinekt.core.Option
import com.code42.jenkins.pipelinekt.core.StageOption
import com.code42.jenkins.pipelinekt.core.option.BuildDiscarder
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.intVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.option.AnsiColor
import com.code42.jenkins.pipelinekt.internal.option.DisableConcurrentBuilds
import com.code42.jenkins.pipelinekt.internal.option.LogRotator
import com.code42.jenkins.pipelinekt.internal.option.Retry
import com.code42.jenkins.pipelinekt.internal.option.SkipDefaultCheckout
import com.code42.jenkins.pipelinekt.internal.option.Timeout
import com.code42.jenkins.pipelinekt.internal.option.Timestamps
import java.util.concurrent.TimeUnit

fun logRotator(numToKeep: Int, daysToKeep: Int, artifactsNumToKeep: Int, artifactDaysToKeep: Int): BuildDiscarder {
    return LogRotator(numToKeep, daysToKeep, artifactsNumToKeep, artifactDaysToKeep)
}
fun DslContext<Option>.buildDiscarder(buildDiscarder: BuildDiscarder) {
    add(buildDiscarder)
}

fun DslContext<Option>.disableConcurrentBuilds() {
    add(DisableConcurrentBuilds)
}

fun DslContext<Option>.ansiColor(colorMapName: String) {
    ansiColor(colorMapName.strDouble())
}
fun DslContext<Option>.ansiColor(colorMapName: Var.Literal.Str) {
    add(AnsiColor(colorMapName))
}
fun DslContext<in StageOption>.skipDefaultCheckout() {
    add(SkipDefaultCheckout)
}

fun DslContext<in StageOption>.timestamps() {
    add(Timestamps)
}

fun DslContext<in StageOption>.timeout(time: Int, unit: TimeUnit) {
    timeout(time.intVar(), unit)
}

fun DslContext<in StageOption>.timeout(time: Var.Literal.Int, unit: TimeUnit) {
    add(Timeout(time, unit))
}

fun DslContext<in StageOption>.retry(time: Int) {
    retry(time.intVar())
}

fun DslContext<in StageOption>.retry(time: Var.Literal.Int) {
    add(Retry(time))
}
