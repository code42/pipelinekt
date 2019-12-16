package com.code42.jenkins.pipelinekt.internal.`when`

import com.code42.jenkins.pipelinekt.core.When
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class ChangeSet(val glob: Var.Literal.Str, val caseSensitive: Var.Literal.Bool) : When {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("changeset glob: ${glob.toGroovy()}, caseSensitive: ${caseSensitive.toGroovy()}")
    }
}
