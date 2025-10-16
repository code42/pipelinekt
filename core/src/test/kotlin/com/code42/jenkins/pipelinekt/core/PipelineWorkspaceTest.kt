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
        assertTrue(result.contains("if (env.BRANCH_NAME)"), "Should check for BRANCH_NAME")
        assertTrue(result.contains("def rootDir = new File(env.WORKSPACE).parentFile.parent"))
        assertTrue(result.contains("def safeBranch = (env.BRANCH_NAME ?: 'unknown').replaceAll(/[^A-Za-z0-9._-]/, '_')"))
        assertTrue(result.contains("def customPath"))
        assertTrue(result.contains("ws(customPath)"))
        assertTrue(result.contains("checkout scm"))
        assertTrue(result.contains("else {"), "Should have else block for non-multibranch")
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
        assertTrue(result.contains("def customPath = \"/my/custom/workspace\""))
        assertTrue(result.contains("ws(customPath)"))
        assertTrue(result.contains("checkout scm"))
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

        // Verify it doesn't use any workspace wrapping
        assertTrue(!result.contains("ws("), "Should NOT use ws() wrapper")
        assertTrue(!result.contains("customPath"), "Should NOT have customPath")
        assertTrue(!result.contains("checkout scm"), "Should NOT have checkout scm")
        assertTrue(result.contains("stages {"), "Should have stages block directly")
    }
}
