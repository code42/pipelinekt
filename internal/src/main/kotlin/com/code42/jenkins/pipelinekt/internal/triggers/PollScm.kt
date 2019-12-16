package com.code42.jenkins.pipelinekt.internal.triggers

import com.code42.jenkins.pipelinekt.core.Trigger
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class PollScm(val cronExpression: Var.Literal.Str) : Trigger {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("pollSCM ${cronExpression.toGroovy()}")
    }
}
