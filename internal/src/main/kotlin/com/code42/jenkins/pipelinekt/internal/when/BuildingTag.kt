package com.code42.jenkins.pipelinekt.internal.`when`

import com.code42.jenkins.pipelinekt.core.When
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

object BuildingTag : When {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("buildingTag()")
    }
}
