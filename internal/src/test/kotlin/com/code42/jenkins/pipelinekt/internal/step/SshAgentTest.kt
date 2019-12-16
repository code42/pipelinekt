package com.code42.jenkins.pipelinekt.internal.step

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.internal.step.declarative.Literal
import com.code42.jenkins.pipelinekt.internal.step.declarative.SshAgent
import kotlin.test.assertEquals
import org.junit.Test

class SshAgentTest : GroovyScriptTest() {
    @Test
    fun testSshAgent() {
        val credId1 = "id1".strSingle()
        val credid2 = "id2".strSingle()

        val steps = Literal("hello step")

        val expected = """
            sshagent(credentials: ['id1','id2']) {
            ${writer.indentStr}${steps.codeBlock}
            }
            
            """.trimIndent()
        SshAgent(listOf(credId1, credid2), steps).toGroovy(writer)
        assertEquals(expected, out.toString())
    }
}
