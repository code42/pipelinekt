package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import kotlin.test.assertEquals
import org.junit.Test

class CleanWsTest : GroovyScriptTest() {
    @Test
    fun defaults_toGroovy() {
        val expected = "cleanWs(deleteDirs: false, disableDeferredWipeout: false)\n"
        CleanWs(deleteDirs = false, disableDeferredWipeout = false).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun override_toGroovy() {
        val expected = "cleanWs(deleteDirs: true, disableDeferredWipeout: true)\n"
        CleanWs(deleteDirs = true, disableDeferredWipeout = true).toGroovy(writer)
        assertEquals(expected, out.toString())
    }
}
