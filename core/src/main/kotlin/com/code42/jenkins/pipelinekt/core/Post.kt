package com.code42.jenkins.pipelinekt.core

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.step.Void
import com.code42.jenkins.pipelinekt.core.writer.GroovyScript
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class Post(
    val always: Step = Void,
    val success: Step = Void,
    val cleanup: Step = Void,
    val changed: Step = Void,
    val fixed: Step = Void,
    val regression: Step = Void,
    val aborted: Step = Void,
    val unsuccessful: Step = Void,
    val unstable: Step = Void,
    val failure: Step = Void
) : GroovyScript {

    override fun toGroovy(writer: GroovyWriter) {
        if (listOf(always, success, cleanup, changed, fixed, regression, aborted, unstable, unstable, failure).any { !it.isEmpty() }) {
            writer.closure("post") { writer ->
                toGroovy("success", success, writer)
                toGroovy("always", always, writer)
                toGroovy("cleanup", cleanup, writer)
                toGroovy("changed", changed, writer)
                toGroovy("fixed", fixed, writer)
                toGroovy("regression", regression, writer)
                toGroovy("aborted", aborted, writer)
                toGroovy("unsuccessful", unsuccessful, writer)
                toGroovy("unstable", unstable, writer)
                toGroovy("failure", failure, writer)
            }
        }
    }
    private fun toGroovy(label: String, step: Step, writer: GroovyWriter) {
        if (!step.isEmpty()) {
            writer.closure(label, step::toGroovy)
        }
    }

    fun merge(other: Post): Post =
        this.copy(
                always = always.andThen(other.always),
                success = success.andThen(other.success),
                cleanup = cleanup.andThen(other.cleanup),
                changed = changed.andThen(other.changed),
                fixed = fixed.andThen(other.fixed),
                regression = regression.andThen(other.regression),
                aborted = aborted.andThen(other.aborted),
                unsuccessful = unsuccessful.andThen(other.unsuccessful),
                unstable = unstable.andThen(other.unstable),
                failure = failure.andThen(other.failure))
}
