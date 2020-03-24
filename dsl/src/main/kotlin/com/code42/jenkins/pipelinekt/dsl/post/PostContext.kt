package com.code42.jenkins.pipelinekt.dsl.post

import com.code42.jenkins.pipelinekt.core.Post
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.writer.ext.toStep
import com.code42.jenkins.pipelinekt.dsl.DslContext

class PostContext(
    val alwaysContext: DslContext<Step> = DslContext(),
    val successContext: DslContext<Step> = DslContext(),
    val failureContext: DslContext<Step> = DslContext(),
    val cleanupContext: DslContext<Step> = DslContext()
) {
    fun always(alwaysBlock: DslContext<Step>.() -> Unit) {
        alwaysContext.alwaysBlock()
    }

    fun success(successBlock: DslContext<Step>.() -> Unit) {
        successContext.successBlock()
    }

    fun failure(failureBlock: DslContext<Step>.() -> Unit) {
        failureContext.failureBlock()
    }

    fun cleanup(cleanupBlock: DslContext<Step>.() -> Unit) {
        cleanupContext.cleanupBlock()
    }

    fun toPost(): Post = Post(always = alwaysContext.drainAll().toStep(), success = successContext.drainAll().toStep(), failure = failureContext.drainAll().toStep(), cleanup = cleanupContext.drainAll().toStep())
}
