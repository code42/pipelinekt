package com.code42.jenkins.pipelinekt.internal.step.scripted

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import kotlin.test.assertEquals
import org.junit.Test

class SetBuildDescriptionTest : GroovyScriptTest() {
    @Test fun setBuildDescription() {
        val description = "Special Build Description Here!"
        SetBuildDescription(description).toGroovy(writer)
        val expected = "script {\n" +
                "\tcurrentBuild.description = \"Special Build Description Here!\"\n" +
                "}\n"
        assertEquals(expected, out.toString())
    }
}
