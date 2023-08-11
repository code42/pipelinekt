package com.code42.jenkins.pipelinekt.dsl.step.scripted

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.scripted.CommitMessageBasedSkip

fun DslContext<Step>.commitMessageBasedSkip() {
    add(CommitMessageBasedSkip())
}

fun DslContext<Step>.commitMessageBasedSkip(regex: String) {
    add(CommitMessageBasedSkip(regex = regex))
}

fun DslContext<Step>.commitMessageBasedSkip(regex: String, result: String) {
    add(CommitMessageBasedSkip(regex = regex, result = result))
}
