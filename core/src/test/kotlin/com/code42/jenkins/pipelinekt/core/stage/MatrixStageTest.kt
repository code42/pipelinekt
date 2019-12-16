package com.code42.jenkins.pipelinekt.core.stage

import com.code42.jenkins.pipelinekt.core.Agent
import com.code42.jenkins.pipelinekt.core.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.Post
import com.code42.jenkins.pipelinekt.core.StageOption
import com.code42.jenkins.pipelinekt.core.TestStep
import com.code42.jenkins.pipelinekt.core.Tool
import com.code42.jenkins.pipelinekt.core.When
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter
import kotlin.test.assertEquals
import org.junit.Test

class MatrixStageTest : GroovyScriptTest() {

    @Test
    fun matrixStage_() {
        Stage.Matrix(
                name = "matrix stage".strDouble(),
                matrixBody = MatrixBody(
                        axes = listOf(
                                MatrixAxis(
                                        "OS".strDouble(),
                                        listOf("mac", "windows", "linux").map { it.strDouble() }),
                                MatrixAxis(
                                        "BROWSER".strDouble(),
                                        listOf("ie", "safari", "chrome", "firefox").map { it.strDouble() })
                        ),
                        excludes = listOf(
                                MatrixExclude(listOf(
                                        ExcludeAxis.Values("OS".strDouble(), listOf("linux".strDouble())),
                                        ExcludeAxis.NotValues(
                                                "BROWSER".strDouble(),
                                                listOf("chrome".strDouble(), "firefox".strDouble()))
                                ))
                        ),
                        stages = listOf(Stage.Steps(
                                name = "nested stage".strDouble(),
                                steps = TestStep("nested")
                        )),
                        agent = TestAgent,
                        whenBlock = listOf(TestWhen("matrix")),
                        tools = listOf(TestTool),
                        options = listOf(TestOption),
                        post = Post(always = TestStep("postAlwaysMatrix()"))
                ),
                whenBlock = listOf(TestWhen("stage")),
                options = listOf(TestOption),
                post = Post(always = TestStep("postAlways()"))).toGroovy(writer)

        val expected = """
            stage("matrix stage") {
            ${writer.indentStr}when {
            ${writer.indentStr.repeat(2)}test == stage
            ${writer.indentStr}}
            ${writer.indentStr}options {
            ${writer.indentStr.repeat(2)}testOption()
            ${writer.indentStr}}
            ${writer.indentStr}matrix {
            ${writer.indentStr.repeat(2)}agent { atHome() }
            ${writer.indentStr.repeat(2)}when {
            ${writer.indentStr.repeat(3)}test == matrix
            ${writer.indentStr.repeat(2)}}
            ${writer.indentStr.repeat(2)}options {
            ${writer.indentStr.repeat(3)}testOption()
            ${writer.indentStr.repeat(2)}}
            ${writer.indentStr.repeat(2)}tools {
            ${writer.indentStr.repeat(3)}usefulTool()
            ${writer.indentStr.repeat(2)}}
            ${writer.indentStr.repeat(2)}axes {
            ${writer.indentStr.repeat(3)}axis {
            ${writer.indentStr.repeat(4)}name "OS"
            ${writer.indentStr.repeat(4)}values "mac", "windows", "linux"
            ${writer.indentStr.repeat(3)}}
            ${writer.indentStr.repeat(3)}axis {
            ${writer.indentStr.repeat(4)}name "BROWSER"
            ${writer.indentStr.repeat(4)}values "ie", "safari", "chrome", "firefox"
            ${writer.indentStr.repeat(3)}}
            ${writer.indentStr.repeat(2)}}
            ${writer.indentStr.repeat(2)}excludes {
            ${writer.indentStr.repeat(3)}exclude {
            ${writer.indentStr.repeat(4)}axis {
            ${writer.indentStr.repeat(5)}name "OS"
            ${writer.indentStr.repeat(5)}values "linux"
            ${writer.indentStr.repeat(4)}}
            ${writer.indentStr.repeat(4)}axis {
            ${writer.indentStr.repeat(5)}name "BROWSER"
            ${writer.indentStr.repeat(5)}notValues "chrome", "firefox"
            ${writer.indentStr.repeat(4)}}
            ${writer.indentStr.repeat(3)}}
            ${writer.indentStr.repeat(2)}}
            ${writer.indentStr.repeat(2)}stages {
            ${writer.indentStr.repeat(3)}stage("nested stage") {
            ${writer.indentStr.repeat(4)}steps {
            ${writer.indentStr.repeat(5)}nested
            ${writer.indentStr.repeat(4)}}
            ${writer.indentStr.repeat(3)}}
            ${writer.indentStr.repeat(2)}}
            ${writer.indentStr.repeat(2)}post {
            ${writer.indentStr.repeat(3)}always {
            ${writer.indentStr.repeat(4)}postAlwaysMatrix()
            ${writer.indentStr.repeat(3)}}
            ${writer.indentStr.repeat(2)}}
            ${writer.indentStr.repeat(1)}}
            ${writer.indentStr.repeat(1)}post {
            ${writer.indentStr.repeat(2)}always {
            ${writer.indentStr.repeat(3)}postAlways()
            ${writer.indentStr.repeat(2)}}
            ${writer.indentStr}}
            }
            
        """.trimIndent()
        assertEquals(expected, out.toString())
    }
}

object TestAgent : Agent {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("agent { atHome() }")
    }
}

object TestTool : Tool {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("usefulTool()")
    }
}

object TestOption : StageOption {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("testOption()")
    }
}

data class TestWhen(val label: String) : When {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("test == $label")
    }
}
