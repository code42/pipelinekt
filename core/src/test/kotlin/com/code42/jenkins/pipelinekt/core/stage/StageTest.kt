package com.code42.jenkins.pipelinekt.core.stage

import com.code42.jenkins.pipelinekt.core.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.TestStep
import com.code42.jenkins.pipelinekt.core.When
import com.code42.jenkins.pipelinekt.core.conditional.BooleanStatement
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter
import kotlin.test.Test
import kotlin.test.assertEquals

class StageTest : GroovyScriptTest() {
    @Test fun nestedSequenceTest() {
        val stage1 = Stage.Steps(
                "my stage".strSingle(),
                steps = TestStep("hello there")
        )
        val stage2 = Stage.Sequence(
                "my sequence".strSingle(),
                stages = listOf(
                        Stage.Steps("sequence 1".strSingle(), steps = TestStep("hello again")),
                        Stage.Steps("sequence 2".strSingle(), steps = TestStep("hello again again")))
        )

        val rootStage = Stage.Sequence(
                "root".strSingle(),
                listOf(stage1, stage2))

        val expected = """
            stage('root') {
            ${indentStr}stages {
            ${indentStr.repeat(2)}stage('my stage') {
            ${indentStr.repeat(3)}steps {
            ${indentStr.repeat(4)}hello there
            ${indentStr.repeat(3)}}
            ${indentStr.repeat(2)}}
            ${indentStr.repeat(2)}stage('my sequence') {
            ${indentStr.repeat(3)}stages {
            ${indentStr.repeat(4)}stage('sequence 1') {
            ${indentStr.repeat(5)}steps {
            ${indentStr.repeat(6)}hello again
            ${indentStr.repeat(5)}}
            ${indentStr.repeat(4)}}
            ${indentStr.repeat(4)}stage('sequence 2') {
            ${indentStr.repeat(5)}steps {
            ${indentStr.repeat(6)}hello again again
            ${indentStr.repeat(5)}}
            ${indentStr.repeat(4)}}
            ${indentStr.repeat(3)}}
            ${indentStr.repeat(2)}}
            ${indentStr.repeat(1)}}
            }
            
        """.trimIndent()
        rootStage.toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test fun topLevelSequenceTest() {
        val stage1 = Stage.Steps(
                "my stage".strSingle(),
                steps = TestStep("hello there")
        )
        val stage2 = Stage.Sequence(
                "my sequence".strSingle(),
                stages = listOf(
                        Stage.Steps("sequence 1".strSingle(), steps = TestStep("hello again")),
                        Stage.Steps("sequence 2".strSingle(), steps = TestStep("hello again again")))
        )

        val rootStage = Stage.Sequence(
                "root".strSingle(),
                listOf(stage1, stage2))

        val expected = """
            stage('root') {
            ${indentStr}stages {
            ${indentStr.repeat(2)}stage('my stage') {
            ${indentStr.repeat(3)}steps {
            ${indentStr.repeat(4)}hello there
            ${indentStr.repeat(3)}}
            ${indentStr.repeat(2)}}
            ${indentStr.repeat(2)}stage('my sequence') {
            ${indentStr.repeat(3)}stages {
            ${indentStr.repeat(4)}stage('sequence 1') {
            ${indentStr.repeat(5)}steps {
            ${indentStr.repeat(6)}hello again
            ${indentStr.repeat(5)}}
            ${indentStr.repeat(4)}}
            ${indentStr.repeat(4)}stage('sequence 2') {
            ${indentStr.repeat(5)}steps {
            ${indentStr.repeat(6)}hello again again
            ${indentStr.repeat(5)}}
            ${indentStr.repeat(4)}}
            ${indentStr.repeat(3)}}
            ${indentStr.repeat(2)}}
            ${indentStr.repeat(1)}}
            }
            
        """.trimIndent()
        rootStage.toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test fun parallelTest() {
        val stage1 = Stage.Steps(
                "my stage".strSingle(),
                steps = TestStep("hello there")
        )
        val stage2 = Stage.Sequence(
                "my sequence".strSingle(),
                stages = listOf(
                        Stage.Steps("sequence 1".strSingle(), steps = TestStep("hello again")),
                        Stage.Steps("sequence 2".strSingle(), steps = TestStep("hello again again")))
        )

        val rootStage = Stage.Parallel(
                "root".strSingle(),
                listOf(stage1, stage2))

        val expected = """
            stage('root') {
            ${indentStr}parallel {
            ${indentStr.repeat(2)}stage('my stage') {
            ${indentStr.repeat(3)}steps {
            ${indentStr.repeat(4)}hello there
            ${indentStr.repeat(3)}}
            ${indentStr.repeat(2)}}
            ${indentStr.repeat(2)}stage('my sequence') {
            ${indentStr.repeat(3)}stages {
            ${indentStr.repeat(4)}stage('sequence 1') {
            ${indentStr.repeat(5)}steps {
            ${indentStr.repeat(6)}hello again
            ${indentStr.repeat(5)}}
            ${indentStr.repeat(4)}}
            ${indentStr.repeat(4)}stage('sequence 2') {
            ${indentStr.repeat(5)}steps {
            ${indentStr.repeat(6)}hello again again
            ${indentStr.repeat(5)}}
            ${indentStr.repeat(4)}}
            ${indentStr.repeat(3)}}
            ${indentStr.repeat(2)}}
            ${indentStr.repeat(1)}}
            }
            
        """.trimIndent()
        rootStage.toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    data class TestWhen(val text: String) : When {
        override fun toGroovy(writer: GroovyWriter) {
            writer.writeln(text)
        }
    }
    @Test
    fun stageWithWhen() {
        val name = "before".strSingle()
        val enabled = true
        val booleanDoTesting = BooleanStatement.Literal("Params.DO_TESTING")

        val stage1 = Stage.Steps(
                name = name,
                steps = TestStep("hello there"),
                whenBlock = listOf(
                        TestWhen("someStatement")))

        val rootStage = Stage.Parallel(
                "root".strSingle(),
                listOf(stage1))

        val expected = """
            stage('root') {
            ${indentStr}parallel {
            ${indentStr.repeat(2)}stage('before') {
            ${indentStr.repeat(3)}when {
            ${indentStr.repeat(4)}someStatement
            ${indentStr.repeat(3)}}
            ${indentStr.repeat(3)}steps {
            ${indentStr.repeat(4)}hello there
            ${indentStr.repeat(3)}}
            ${indentStr.repeat(2)}}
            ${indentStr.repeat(1)}}
            }

        """.trimIndent().replace("\n", System.getProperty("line.separator"))
        rootStage.toGroovy(writer)
        assertEquals(expected, out.toString())
    }
}
