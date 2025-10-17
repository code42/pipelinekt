package com.code42.jenkins.pipelinekt.internal.agent

import com.code42.jenkins.pipelinekt.core.Agent
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * Represents a simple Jenkins label agent.
 *
 * When useCustomWorkspaceVariable is true (typically in multibranch pipelines),
 * this will expand to use a node block with customWorkspace to prevent path
 * truncation and branch conflicts.
 *
 * @param label The agent label to match against
 * @param useCustomWorkspaceVariable If true, expands to node block with customWorkspacePath variable
 */
data class Label(
    val label: Var.Literal.Str,
    val useCustomWorkspaceVariable: Boolean = false,
) : Agent {
    override fun toGroovy(writer: GroovyWriter) {
        writer.closure("agent") { writer ->
            if (useCustomWorkspaceVariable) {
                // Expand to node block with customWorkspace for multibranch support
                writer.closure("node") { writer ->
                    writer.writeln("label ${label.toGroovy()}")
                    writer.writeln("customWorkspace customWorkspacePath")
                }
            } else {
                writer.writeln("label ${label.toGroovy()}")
            }
        }
    }

    override fun withCustomWorkspaceVariable() = this.copy(useCustomWorkspaceVariable = true)
}
