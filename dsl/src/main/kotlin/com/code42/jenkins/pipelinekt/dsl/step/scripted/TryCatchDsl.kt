package com.code42.jenkins.pipelinekt.dsl.step.scripted

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.writer.ext.toStep
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.scripted.Try

@Suppress("UnusedPrivateMember")
fun DslContext<Step>.`try`(trySteps: DslContext<Step>.() -> Unit, catchSteps: (DslContext<Step>.() -> Unit)?) {
    tryCatch(trySteps, catchSteps)
}

fun DslContext<Step>.tryCatch(tryStep: DslContext<Step>.() -> Unit, catchStep: (DslContext<Step>.() -> Unit)?) {
    val trySteps = DslContext.into(tryStep).toStep()
    if (catchStep != null) {
        val catchSteps = DslContext.into(catchStep).toStep()
        add(Try(trySteps, catchSteps))
    } else {
        add(Try(trySteps, null))
    }
}
