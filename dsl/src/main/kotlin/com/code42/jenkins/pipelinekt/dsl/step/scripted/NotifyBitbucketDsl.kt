package com.code42.jenkins.pipelinekt.dsl.step.scripted

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.scripted.NotifyBitbucket

fun DslContext<Step>.notifyBitbucket() {
    add(NotifyBitbucket)
}
