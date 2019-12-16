package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import kotlin.test.assertEquals
import org.junit.Test

class DirTest : GroovyScriptTest() {
    @Test fun testDir() {
        val step1 = Literal("my step1")
        val step2 = Literal("my step2")
        val expected = "dir('myDir') {\n" +
                "${writer.indentStr}my step1\n" +
                "${writer.indentStr}my step2\n" +
                "}\n"

        Dir("myDir".strSingle(), step1.andThen(step2)).toGroovy(writer)
        assertEquals(expected, out.toString())
    }
}
