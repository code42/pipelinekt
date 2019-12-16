package com.code42.jenkins.pipelinekt.core.stage

import com.code42.jenkins.pipelinekt.core.Agent
import com.code42.jenkins.pipelinekt.core.Post
import com.code42.jenkins.pipelinekt.core.StageOption
import com.code42.jenkins.pipelinekt.core.Tool
import com.code42.jenkins.pipelinekt.core.When
import com.code42.jenkins.pipelinekt.core.writer.GroovyScript
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter
import com.code42.jenkins.pipelinekt.core.writer.ext.toGroovy

data class MatrixBody(
    val axes: List<MatrixAxis>,
    val excludes: List<MatrixExclude>,
    val stages: List<Stage>,
    val agent: Agent? = null,
    val whenBlock: List<When> = emptyList(),
    val tools: List<Tool> = emptyList(),
    val options: List<StageOption> = emptyList(),
    val post: Post = Post()
) : GroovyScript {
    override fun toGroovy(writer: GroovyWriter) {
        writer.closure("matrix") { writer ->

            agent?.toGroovy(writer)
            if (whenBlock.isNotEmpty()) {
                writer.closure("when", whenBlock::toGroovy)
            }
            if (options.isNotEmpty()) {
                writer.closure("options", options::toGroovy)
            }
            if (tools.isNotEmpty()) {
                writer.closure("tools", tools::toGroovy)
            }

            if (axes.isNotEmpty()) {
                writer.closure("axes", axes::toGroovy)
            }
            if (excludes.isNotEmpty()) {
                writer.closure("excludes", excludes::toGroovy)
            }

            writer.closure("stages", stages::toGroovy)

            post.toGroovy(writer)
        }
    }
}
