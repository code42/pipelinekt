package com.code42.jenkins.pipelinekt.internal.step.scripted

import com.code42.jenkins.pipelinekt.core.step.ScriptedStep
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * This is not the preferred way to do parallel work.  Hover, pipelines support a limited amount of parallelism
 * in declarative stages.  Do NOT use this unless you have exceeded the max parallelism in declarative stages.
 *
 * Using this method causes the Blue Ocean UI to misbhave - the ui gets slow and
 * stages don't display correctly.
 *
 * @param scriptedStages a set of psuedo stages to execute similar to parallel stages in a declarative context.
 *
 */
data class ScriptedParallel(val scriptedStages: Map<out Var.Literal.Str, Step>) : ScriptedStep, Step {
    override fun isEmpty(): Boolean = scriptedStages.isEmpty() || scriptedStages.all { it.value.isEmpty() }

    override fun contains(other: Step): Boolean =
            this.equals(other) || this.scriptedStages.any { (k, v) -> v.contains(other) }

    override fun any(fn: (Step) -> Boolean): Boolean = fn(this) || this.scriptedStages.any { (k, v) -> v.any(fn) }

    override fun scriptedGroovy(writer: GroovyWriter) {
        writer.writeln("def scriptedStages = [:]")
        scriptedStages.forEach {
            writer.closure("scriptedStages[${it.key.toGroovy()}] = ", it.value::toGroovy)
        }
        writer.writeln("parallel scriptedStages")
    }
}
