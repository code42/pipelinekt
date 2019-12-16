package com.code42.jenkins.pipelinekt.core.step

interface SingletonStep : Step {
    override fun isEmpty(): Boolean = false

    override fun contains(other: Step): Boolean = this.equals(other)

    override fun any(fn: (Step) -> Boolean): Boolean = fn(this)
}
