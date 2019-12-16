package com.code42.jenkins.pipelinekt.core.step

interface NestedStep : Step {
    val steps: Step

    override fun isEmpty(): Boolean = steps.isEmpty()

    override fun contains(other: Step): Boolean =
            this.equals(other) || this.steps.contains(other)

    override fun any(fn: (Step) -> Boolean): Boolean = fn(this) || steps.any(fn)
}
