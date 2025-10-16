package com.code42.jenkins.pipelinekt.internal.environment

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import org.junit.Test
import kotlin.test.assertEquals

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
