package com.code42.jenkins.pipelinekt.core.utils

import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.vars.Var.Environment
import com.code42.jenkins.pipelinekt.core.vars.Var.Literal.Str

/**
 * Utility functions for working with workspace paths
 */
object WorkspacePath {
    /**
     * Generates a workspace path for a branch in a multibranch pipeline
     * @param basePath The base path to use for workspace directories
     * @param branchEnvVar The environment variable name containing the branch name (default: BRANCH_NAME)
     * @return A string literal representing the workspace path with the branch name interpolated
     */
    fun forBranch(basePath: String, branchEnvVar: String = "BRANCH_NAME"): Str {
        val branchVar = Environment(branchEnvVar)
        return "\${basePath}-\${${branchVar.toGroovy()}}".strDouble()
    }
    
    /**
     * Generates a workspace path for a specific directory
     * @param basePath The base path to use
     * @param subDir The subdirectory to append to the base path
     * @return A string literal representing the complete workspace path
     */
    fun forDir(basePath: String, subDir: String): Str {
        return "$basePath/$subDir".strSingle()
    }
}