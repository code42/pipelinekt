package com.code42.jenkins.pipelinekt.core

import com.code42.jenkins.pipelinekt.core.writer.GroovyScript
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class PipelineLibrary(val name: String, val version: String, val suffix: String = "_") : GroovyScript {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("@Library(\"$name@$version\") $suffix")
    }
}
