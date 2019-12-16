package com.code42.jenkins.pipelinekt.internal.step.scripted

import com.code42.jenkins.pipelinekt.core.step.NestedStep
import com.code42.jenkins.pipelinekt.core.step.ScriptedStep
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * You should not have to use this step.  This is from the old scripted pipelines.  However, this is present for users
 * who require this functionality; for example parallelism that exceeds the max allowed by declarative stages, see
 * com.code42.jenkins.pipelinekt.step.scripted.ScriptedParallel
 *
 * Using this method causes the Blue Ocean UI to misbhave - the ui gets slow and
 * stages don't display correctly.
 *
 * @param label the node label to choose
 * @param steps the steps to execute on the node
 */
data class Node(val label: Var.Literal.Str, override val steps: Step) : ScriptedStep, NestedStep {
    override fun scriptedGroovy(writer: GroovyWriter) {
        writer.closure("node(${label.toGroovy()})", steps::toGroovy)
    }
}
