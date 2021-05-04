package com.code42.jenkins.pipelinekt.internal.environment

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import kotlin.test.assertEquals
import org.junit.Test

class EnvironmentTest : GroovyScriptTest() {
    @Test
    fun envVarIsWellFormatted() {
        val name = "FOO"
        val value = "BAR"
        val expected = "$name=\"$value\"\n"
        EnvVar(name, value).toGroovy(writer)
        assertEquals(expected, out.toString())
    }
}
