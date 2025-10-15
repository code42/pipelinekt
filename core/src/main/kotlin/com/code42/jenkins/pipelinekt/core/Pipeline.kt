package com.code42.jenkins.pipelinekt.core

import com.code42.jenkins.pipelinekt.core.method.PipelineMethod
import com.code42.jenkins.pipelinekt.core.stage.Stage
import com.code42.jenkins.pipelinekt.core.writer.GroovyScript
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter
import com.code42.jenkins.pipelinekt.core.writer.ext.toGroovy
import java.io.File

fun generatePipeline(
    pipeline: Pipeline,
    outFile: String,
    indentStr: String = "  ",
    imports: List<String> = emptyList()
) {
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
    val useMultibranchWorkspace: Boolean = true
) : GroovyScript {
    override fun toGroovy(writer: GroovyWriter) {
        if (methods.isNotEmpty()) {
            methods.toGroovy(writer)
        }

        writer.closure("pipeline") { writer ->
            if (environment.isNotEmpty()) {
                writer.closure("environment", environment::toGroovy)
            }
            agent?.toGroovy(writer)
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
            
            // Handle custom workspace logic
            if (customWorkspace != null || useMultibranchWorkspace) {
                // If a specific custom workspace is provided, use it directly
                if (customWorkspace != null) {
                    writer.writeln("def customPath = \"$customWorkspace\"")
                    writer.closure("ws(customPath)") { wsWriter ->
                        wsWriter.writeln("checkout scm")
                        wsWriter.closure("stages", stages::toGroovy)
                        post.toGroovy(wsWriter)
                    }
                } else if (useMultibranchWorkspace) {
                    // Generate multibranch workspace path calculation
                    writer.writeln("def rootDir = new File(env.WORKSPACE).parentFile.parent")
                    writer.writeln("def safeBranch = (env.BRANCH_NAME ?: 'unknown').replaceAll(/[^A-Za-z0-9._-]/, '_')")
                    writer.writeln("def customPath = \"${"\${rootDir}/${"\${env.JOB_NAME}-\${safeBranch}"}"}\"")
                    writer.closure("ws(customPath)") { wsWriter ->
                        wsWriter.writeln("checkout scm")
                        wsWriter.closure("stages", stages::toGroovy)
                        post.toGroovy(wsWriter)
                    }
                }
            } else {
                // Regular pipeline without custom workspace
                writer.closure("stages", stages::toGroovy)
                post.toGroovy(writer)
            }
        }
    }
}
