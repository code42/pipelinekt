package com.code42.jenkins.pipelinekt.core.stage

import com.code42.jenkins.pipelinekt.core.Agent
import com.code42.jenkins.pipelinekt.core.Post
import com.code42.jenkins.pipelinekt.core.StageOption
import com.code42.jenkins.pipelinekt.core.Tool
import com.code42.jenkins.pipelinekt.core.When
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyScript
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter
import com.code42.jenkins.pipelinekt.core.writer.ext.toGroovy

/**
 * A declarative Jenkinsfile Stage
 */
sealed class Stage : GroovyScript {
    abstract val agent: Agent?
    abstract val post: Post?
    abstract val whenBlock: List<When>?
    abstract val tools: List<Tool>
    abstract val options: List<StageOption>
    /**
     * Execute stages in parallel
     *
     * @param name the name of the stage
     * @param stages the stages to execute in parallel
     */
    data class Parallel(
        val name: Var.Literal.Str,
        val stages: List<Stage>,
        override val agent: Agent? = null,
        override val whenBlock: List<When> = emptyList(),
        override val tools: List<Tool> = emptyList(),
        override val options: List<StageOption> = emptyList(),
        override val post: Post = Post()
    ) : Stage() {

        override fun toGroovy(writer: GroovyWriter) {

            writer.closure("stage(${name.toGroovy()})") { writer ->
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

                writer.closure("parallel", stages::toGroovy)

                post.toGroovy(writer)
            }
        }
    }

    data class Sequence(
        val name: Var.Literal.Str,
        val stages: List<Stage>,
        override val agent: Agent? = null,
        override val whenBlock: List<When> = emptyList(),
        override val tools: List<Tool> = emptyList(),
        override val options: List<StageOption> = emptyList(),
        override val post: Post = Post()
    ) : Stage() {

        override fun toGroovy(writer: GroovyWriter) {
            writer.closure("stage(${name.toGroovy()})") { writer ->
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

                writer.closure("stages", stages::toGroovy)

                post.toGroovy(writer)
            }
        }
    }

    /**
     * A declarative stage
     *
     * @param name the stage name
     * @param agent the optional agent definition
     * @param steps the steps to execute
     * @param post steps to execute after steps has completed
     */
    data class Steps(
        val name: Var.Literal.Str,
        val steps: Step,
        override val agent: Agent? = null,
        override val whenBlock: List<When> = emptyList(),
        override val tools: List<Tool> = emptyList(),
        override val options: List<StageOption> = emptyList(),
        override val post: Post = Post()
    ) : Stage() {

        override fun toGroovy(writer: GroovyWriter) {
            writer.closure("stage(${name.toGroovy()})") { writer ->
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

                writer.closure("steps", steps::toGroovy)
                post.toGroovy(writer)
            }
        }
    }

    data class Matrix(
        val name: Var.Literal.Str,
        val matrixBody: MatrixBody,
        override val whenBlock: List<When> = emptyList(),
        override val options: List<StageOption> = emptyList(),
        override val post: Post = Post()
    ) : Stage() {
        override val agent: Agent? = null
        override val tools: List<Tool> = emptyList()

        override fun toGroovy(writer: GroovyWriter) {
            writer.closure("stage(${name.toGroovy()})") { writer ->
                if (whenBlock.isNotEmpty()) {
                    writer.closure("when", whenBlock::toGroovy)
                }
                if (options.isNotEmpty()) {
                    writer.closure("options", options::toGroovy)
                }

                matrixBody.toGroovy(writer)

                post.toGroovy(writer)
            }
        }
    }
}
