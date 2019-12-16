package com.code42.jenkins.pipelinekt.core.stage

import com.code42.jenkins.pipelinekt.core.writer.GroovyScript
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter
import com.code42.jenkins.pipelinekt.core.writer.ext.toGroovy

data class MatrixExclude(val axes: List<ExcludeAxis>) : GroovyScript {
    override fun toGroovy(writer: GroovyWriter) {
        writer.closure("exclude", axes::toGroovy)
    }
}
