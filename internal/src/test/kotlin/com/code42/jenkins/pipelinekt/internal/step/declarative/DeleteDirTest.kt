package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import kotlin.test.assertEquals
import org.junit.Test

class DeleteDirTest : GroovyScriptTest() {
    @Test
    fun defaults_toGroovy() {
        val expected = "deleteDir()\n"
        DeleteDir.toGroovy(writer)
        assertEquals(expected, out.toString())
    }
}
