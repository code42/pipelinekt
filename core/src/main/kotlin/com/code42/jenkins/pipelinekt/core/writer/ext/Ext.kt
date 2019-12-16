package com.code42.jenkins.pipelinekt.core.writer.ext

import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyScript
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

fun List<GroovyScript>.toGroovy(writer: GroovyWriter) {
    if (this.all { it is Step } && !this.all { it is DeclarativeStep }) {
        writer.scripted { writer ->
            this.forEach { it.toGroovy(writer) }
        }
    } else {
        this.forEach { it.toGroovy(writer) }
    }
}

fun Map<out Var, out Var>.toGroovy(writer: GroovyWriter) {
    writer.writeln("[")
    this.map { "${writer.indentStr}${it.key.toGroovy()}: ${it.value.toGroovy()}" }
            .allButLast { str -> "$str," }
            .forEach(writer::writeln)
    writer.writeln("]")
}
