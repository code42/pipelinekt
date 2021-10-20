package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import kotlin.test.assertEquals
import org.junit.Test

class WithFolderPropertiesTest : GroovyScriptTest() {
    @Test
    fun withVaultBlockTest_singleVar() {
        val expected1 = "withFolderProperties {\n" +
                "${indentStr}sh (script: \"echo testing...\", returnStdout: false)\n" +
                "}\n"
        WithFolderProperties(steps = Sh("echo testing...".strDouble())).toGroovy(writer)
        assertEquals(expected1, out.toString())
    }
}
