package com.code42.jenkins.pipelinekt.core

import com.code42.jenkins.pipelinekt.core.stage.Stage
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter
import org.junit.Test
import java.io.PrintWriter
import java.io.StringWriter
import kotlin.test.assertTrue

class PipelineWorkspaceTest {

    @Test
    fun `pipeline with useMultibranchWorkspace true generates runtime check`() {
        val pipeline = Pipeline(
            stages = listOf(
                Stage.Steps(
                    name = "Build".strDouble(),
                    steps = TestStep("echo 'build'"),
                ),
            ),
            useMultibranchWorkspace = true,
        )

        val stringWriter = StringWriter()
        val writer = GroovyWriter(PrintWriter(stringWriter), 0, indentStr = "  ")
        pipeline.toGroovy(writer)
        val result = stringWriter.toString()

        println("=== Generated Jenkinsfile with useMultibranchWorkspace=true ===")
        println(result)

        // Verify it contains the runtime check
        assertTrue(result.contains("if (env.BRANCH_NAME)"), "Should check for BRANCH_NAME to detect multibranch")
        assertTrue(result.contains("def decodedJobName = java.net.URLDecoder.decode(env.JOB_NAME, 'UTF-8')"), "Should decode URL-encoded job name")
        assertTrue(result.contains("def safeJobName = decodedJobName.replaceAll(/[^A-Za-z0-9._-]/, '_')"), "Should sanitize job name")
        assertTrue(result.contains("customWorkspacePath"), "Should define customWorkspacePath")
        assertTrue(result.contains("customWorkspace customWorkspacePath"), "Should use customWorkspacePath in agent")
    }

    @Test
    fun `pipeline with custom workspace uses it directly`() {
        val pipeline = Pipeline(
            stages = listOf(
                Stage.Steps(
                    name = "Build".strDouble(),
                    steps = TestStep("echo 'build'"),
                ),
            ),
            customWorkspace = "/my/custom/workspace",
        )

        val stringWriter = StringWriter()
        val writer = GroovyWriter(PrintWriter(stringWriter), 0, indentStr = "  ")
        pipeline.toGroovy(writer)
        val result = stringWriter.toString()

        println("\n=== Generated Jenkinsfile with customWorkspace ===")
        println(result)

        // Verify it uses custom workspace directly
        assertTrue(result.contains("def customWorkspacePath = \"/my/custom/workspace\""), "Should define customWorkspacePath with custom value")
        assertTrue(result.contains("customWorkspace customWorkspacePath"), "Should use customWorkspacePath in agent")
        assertTrue(!result.contains("if (env.BRANCH_NAME)"), "Should NOT check for BRANCH_NAME when custom workspace is set")
    }

    @Test
    fun `pipeline with useMultibranchWorkspace false uses default workspace`() {
        val pipeline = Pipeline(
            stages = listOf(
                Stage.Steps(
                    name = "Build".strDouble(),
                    steps = TestStep("echo 'build'"),
                ),
            ),
            useMultibranchWorkspace = false,
        )

        val stringWriter = StringWriter()
        val writer = GroovyWriter(PrintWriter(stringWriter), 0, indentStr = "  ")
        pipeline.toGroovy(writer)
        val result = stringWriter.toString()

        println("\n=== Generated Jenkinsfile with useMultibranchWorkspace=false ===")
        println(result)

        // Verify it doesn't use any custom workspace logic
        assertTrue(!result.contains("customWorkspacePath"), "Should NOT have customWorkspacePath")
        assertTrue(!result.contains("if (env.BRANCH_NAME)"), "Should NOT check for BRANCH_NAME")
        assertTrue(result.contains("stages {"), "Should have stages block directly")
    }
}
