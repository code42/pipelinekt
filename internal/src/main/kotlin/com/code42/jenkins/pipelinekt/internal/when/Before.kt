package com.code42.jenkins.pipelinekt.internal.`when`

import com.code42.jenkins.pipelinekt.core.When
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

sealed class Before : When {
    abstract val enabled: Boolean
    abstract val name: String
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("$name $enabled")
    }
    data class Agent(override val enabled: Boolean) : Before() {
        override val name: String = "beforeAgent"
    }
    data class Input(override val enabled: Boolean) : Before() {
        override val name: String = "beforeInput"
    }
}
