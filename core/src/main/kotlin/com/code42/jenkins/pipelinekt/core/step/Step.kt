package com.code42.jenkins.pipelinekt.core.step

import com.code42.jenkins.pipelinekt.core.writer.GroovyScript

interface Step : GroovyScript {
    fun andThen(next: () -> Step) = andThen(next())

    fun andThen(next: Step): Step =
            when (next) {
                is Sequence -> next.precededBy(this)
                is Void -> this
                else -> Sequence(listOf(this, next))
            }

    fun precededBy(previous: Step): Step =
            when (previous) {
                is Sequence -> previous.andThen(this)
                is Void -> this
                else -> Sequence(listOf(previous, this))
            }
    fun isEmpty(): Boolean
    fun contains(other: Step): Boolean
    fun any(fn: (Step) -> Boolean): Boolean
}
