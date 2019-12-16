package com.code42.jenkins.pipelinekt.core.step

import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter
import com.code42.jenkins.pipelinekt.core.writer.ext.toGroovy

data class Sequence(val steps: List<Step>) : DeclarativeStep {

    override fun isEmpty(): Boolean = steps.isEmpty() || steps.all { it.isEmpty() }

    override fun andThen(next: Step): Step =
            when (next) {
                is Sequence -> this.copy(steps = steps + next.steps)
                is Void -> this
                else -> this.copy(steps = steps + next)
            }

    override fun precededBy(previous: Step): Step =
            when (previous) {
                is Sequence -> this.copy(steps = previous.steps + steps)
                is Void -> this
                else -> this.copy(steps = listOf(previous) + steps)
            }
    override fun contains(other: Step): Boolean = this.steps.any { it.contains(other) }

    override fun toGroovy(writer: GroovyWriter) {
        steps.toGroovy(writer)
    }

    override fun any(fn: (Step) -> Boolean): Boolean = fn(this) || steps.any(fn)

    fun flatten(): Step =
        steps.fold<Step, Step>(Void, { flattendSteps, step ->
            when (step) {
                is Sequence -> flattendSteps.andThen(step.flatten())
                else -> flattendSteps.andThen(step)
            }
        })
}
