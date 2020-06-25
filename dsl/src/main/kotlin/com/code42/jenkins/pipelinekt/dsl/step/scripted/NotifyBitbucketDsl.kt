package com.code42.jenkins.pipelinekt.dsl.step.scripted

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.scripted.NotifyBitbucket
import com.code42.jenkins.pipelinekt.internal.step.scripted.NotifyBitbucketSha1

fun DslContext<Step>.notifyBitbucket() {
    add(NotifyBitbucket)
}

fun DslContext<Step>.notifyBitbucket(sha1: String) {
    add(NotifyBitbucketSha1(sha1 = sha1))
}
