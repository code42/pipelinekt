package com.code42.jenkins.pipelinekt.internal.agent

import com.code42.jenkins.pipelinekt.core.Agent
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * Represents a Jenkins node agent with optional custom workspace.
 *
 * When used in a pipeline with useMultibranchWorkspace=true, the customWorkspace
 * will reference the dynamically calculated customWorkspacePath variable, which
 * ensures each branch gets its own workspace and prevents path truncation issues.
 *
 * @param label The node label to match against
 * @param customWorkspace Optional custom workspace path. If null and pipeline uses multibranch,
 *                        will automatically reference the calculated customWorkspacePath variable.
 * @param useCustomWorkspaceVariable If true, uses the customWorkspacePath variable instead of a literal value
 */
data class Node(
    val label: Var.Literal.Str,
    val customWorkspace: Var.Literal.Str? = null,
    val useCustomWorkspaceVariable: Boolean = false,
) : Agent {
    override fun toGroovy(writer: GroovyWriter) {
        writer.closure("agent") { writer ->
            writer.closure("node") { writer ->
                writer.writeln("label ${label.toGroovy()}")
                if (useCustomWorkspaceVariable) {
                    // Reference the customWorkspacePath variable calculated before pipeline block
                    writer.writeln("customWorkspace customWorkspacePath")
                } else {
                    customWorkspace?.let { writer.writeln("customWorkspace ${it.toGroovy()}") }
                }
            }
        }
    }

    override fun withCustomWorkspaceVariable() = this.copy(useCustomWorkspaceVariable = true)
}
