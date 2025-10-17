package com.code42.jenkins.pipelinekt.core

import com.code42.jenkins.pipelinekt.core.method.PipelineMethod
import com.code42.jenkins.pipelinekt.core.stage.Stage
import com.code42.jenkins.pipelinekt.core.writer.GroovyScript
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter
import com.code42.jenkins.pipelinekt.core.writer.ext.toGroovy
import java.io.File

fun generatePipeline(pipeline: Pipeline, outFile: String, indentStr: String = "  ", imports: List<String> = emptyList()) {
    val dir = outFile.substringBeforeLast('/')
    File(dir).mkdirs()
    val writer = GroovyWriter.forFile(File(outFile), indentStr)
    for (import in imports) {
        writer.writeln("import $import")
    }
    pipeline.toGroovy(writer)
}

data class Pipeline(
    val environment: List<Environment> = emptyList(),
    val agent: Agent? = null,
    val tools: List<Tool> = emptyList(),
    val options: List<Option> = emptyList(),
    val triggers: List<Trigger> = emptyList(),
    val parameters: List<Parameter> = emptyList(),
    val stages: List<Stage> = emptyList(),
    val methods: List<PipelineMethod> = emptyList(),
    val post: Post = Post(),
    val customWorkspace: String? = null,
    val useMultibranchWorkspace: Boolean = true,
) : GroovyScript {

    /**
     * Transforms an agent to use customWorkspacePath for multibranch pipelines.
     */
    private fun Agent.withMultibranchWorkspace(): Agent {
        return if (useMultibranchWorkspace || customWorkspace != null) {
            this.withCustomWorkspaceVariable()
        } else {
            this
        }
    }

    /**
     * Recursively transforms stages to use customWorkspacePath for their agents.
     */
    private fun Stage.withMultibranchWorkspace(pipeline: Pipeline): Stage {
        val transformedAgent = this.agent?.withMultibranchWorkspace()

        return when (this) {
            is Stage.Steps -> this.copy(agent = transformedAgent)
            is Stage.Parallel -> this.copy(
                agent = transformedAgent,
                stages = stages.map { it.withMultibranchWorkspace(pipeline) },
            )
            is Stage.Sequence -> this.copy(
                agent = transformedAgent,
                stages = stages.map { it.withMultibranchWorkspace(pipeline) },
            )
            is Stage.Matrix -> this // Matrix doesn't support agent transformation
        }
    }

    override fun toGroovy(writer: GroovyWriter) {
        if (methods.isNotEmpty()) {
            methods.toGroovy(writer)
        }

        // Calculate custom workspace path BEFORE pipeline block for multibranch pipelines
        // This ensures each branch gets its own workspace to avoid conflicts and
        // prevent workspace path truncation issues in Jenkins
        if (customWorkspace != null) {
            writer.writeln("// Custom workspace specified")
            writer.writeln("def customWorkspacePath = \"$customWorkspace\"")
            writer.writeln("")
        } else if (useMultibranchWorkspace) {
            writer.writeln("// Calculate custom workspace for multibranch pipelines")
            writer.writeln("// This prevents workspace path truncation and branch conflicts")
            writer.writeln("// by using a relative path that includes the sanitized branch name")
            writer.writeln("def customWorkspacePath = null")
            writer.writeln("if (env.BRANCH_NAME) {")
            val innerWriter = writer.inner()
            innerWriter.writeln("def safeBranch = env.BRANCH_NAME.replaceAll(/[^A-Za-z0-9._-]/, '_')")
            innerWriter.writeln("customWorkspacePath = \"./workspace//\${env.JOB_NAME}-\${safeBranch}\"")
            writer.writeln("}")
            writer.writeln("")
        }

        writer.closure("pipeline") { writer ->
            if (environment.isNotEmpty()) {
                writer.closure("environment", environment::toGroovy)
            }
            // Transform agent to use customWorkspacePath if multibranch is enabled
            agent?.withMultibranchWorkspace()?.toGroovy(writer)
            if (tools.isNotEmpty()) {
                writer.closure("tools", tools::toGroovy)
            }
            if (options.isNotEmpty()) {
                writer.closure("options", options::toGroovy)
            }
            if (triggers.isNotEmpty()) {
                writer.closure("triggers", triggers::toGroovy)
            }
            if (parameters.isNotEmpty()) {
                writer.closure("parameters", parameters::toGroovy)
            }

            // For multibranch or custom workspace, agents will reference customWorkspacePath
            // Transform stage agents as well
            val transformedStages = stages.map { it.withMultibranchWorkspace(this) }
            writer.closure("stages") { stageWriter ->
                transformedStages.toGroovy(stageWriter)
            }
            post.toGroovy(writer)
        }
    }
}
