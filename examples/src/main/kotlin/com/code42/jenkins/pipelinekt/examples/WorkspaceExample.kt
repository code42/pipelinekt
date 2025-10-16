package com.code42.jenkins.pipelinekt.examples

import com.code42.jenkins.pipelinekt.core.Pipeline
import com.code42.jenkins.pipelinekt.core.utils.WorkspacePath
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.dsl.pipeline
import com.code42.jenkins.pipelinekt.dsl.stage
import com.code42.jenkins.pipelinekt.dsl.step.declarative.sh
import com.code42.jenkins.pipelinekt.dsl.step.scripted.ws

/**
 * Example showing how to use custom workspace directories
 */
fun workspaceExample(): Pipeline {
    return pipeline(pipelineBlock = {
        stage("Default Workspace") {
            sh("pwd") // Run in default workspace
        }

        stage("Custom Workspace") {
            ws("/tmp/custom-workspace") {
                sh("pwd") // Run in custom workspace
                sh("echo 'Working in custom directory'")
            }
        }

        stage("Multibranch Workspace") {
            // Using the utility to generate branch-specific workspace
            ws(WorkspacePath.forBranch("/tmp/workspace")) {
                sh("pwd")
                sh("echo 'Working in branch-specific directory'")
            }
        }

        stage("Project Workspace") {
            // Using the utility to generate project-specific workspace
            ws(WorkspacePath.forDir("/tmp/projects", "my-project")) {
                sh("pwd")
                sh("echo 'Working in project-specific directory'")
            }
        }

        // You can also use string interpolation directly with the strDouble extension
        stage("Custom Branch Workspace") {
            ws("/tmp/custom-\${env.BRANCH_NAME}".strDouble()) {
                sh("pwd")
                sh("echo 'Working in custom branch directory'")
            }
        }
    })
}
