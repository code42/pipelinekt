package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import org.junit.Test
import kotlin.test.assertEquals

class DeleteDirTest : GroovyScriptTest() {
    @Test
    fun defaults_toGroovy() {
        val expected = "deleteDir()\n"
        DeleteDir.toGroovy(writer)
        assertEquals(expected, out.toString())
    }
}
