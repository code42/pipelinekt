package com.code42.jenkins.pipelinekt.internal.agent

import com.code42.jenkins.pipelinekt.core.Agent
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

object Any : Agent {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("agent any")
    }
}
