package com.code42.jenkins.pipelinekt.core.writer.ext

import com.code42.jenkins.pipelinekt.core.step.Step

fun <T> List<T>.allButLast(fn: (T) -> T): List<T> {
    return this.mapIndexed { idx, t -> if (idx == this.size - 1) t else fn(t) }
}

fun List<Step>.toStep() = com.code42.jenkins.pipelinekt.core.step.Sequence(this).flatten()
