package com.code42.jenkins.pipelinekt.internal.environment

import com.code42.jenkins.pipelinekt.core.Environment
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class EnvVar(val name: String, val value: String) : Environment {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("$name=\"$value\"")
    }
}
