package com.code42.jenkins.pipelinekt.internal.step.scripted

import com.code42.jenkins.pipelinekt.core.conditional.BooleanStatement
import com.code42.jenkins.pipelinekt.core.step.NestedStep
import com.code42.jenkins.pipelinekt.core.step.ScriptedStep
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.step.Void
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class If(
    val statement: BooleanStatement,
    val ifTrue: Step,
    val otherwise: Step? = null
) : ScriptedStep, NestedStep {
    override val steps: Step
        get() = ifTrue.andThen(otherwise ?: Void)

    override fun scriptedGroovy(writer: GroovyWriter) {
        writer.closure("if(${statement.toGroovy()})", ifTrue::toGroovy)
        otherwise?.let { writer.closure("else", it::toGroovy) }
    }
}
