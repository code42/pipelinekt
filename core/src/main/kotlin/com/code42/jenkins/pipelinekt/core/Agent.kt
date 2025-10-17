package com.code42.jenkins.pipelinekt.core

import com.code42.jenkins.pipelinekt.core.writer.GroovyScript

interface Agent : GroovyScript {
    /**
     * Returns a copy of this agent configured to use the customWorkspacePath variable.
     * This is used for multibranch pipelines to ensure consistent workspace paths.
     * Default implementation returns this agent unchanged.
     */
    fun withCustomWorkspaceVariable(): Agent = this
}
