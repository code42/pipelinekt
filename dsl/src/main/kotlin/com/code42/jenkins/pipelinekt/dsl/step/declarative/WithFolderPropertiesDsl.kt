package com.code42.jenkins.pipelinekt.dsl.step.declarative

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.writer.ext.toStep
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.declarative.WithFolderProperties

fun DslContext<Step>.withFolderProperties(steps: DslContext<Step>.() -> Unit) {
    add(WithFolderProperties(DslContext.into(steps).toStep()))
}
