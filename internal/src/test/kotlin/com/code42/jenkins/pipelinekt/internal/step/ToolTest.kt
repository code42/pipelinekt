package com.code42.jenkins.pipelinekt.internal.step

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.internal.step.declarative.Tool
import kotlin.test.assertEquals
import org.junit.Test

class ToolTest : GroovyScriptTest() {
    @Test fun noType_toGroovy() {
        val name = "tool_name".strSingle()
        val expected = "tool name: ${name.toGroovy()}\n"
        Tool(name).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test fun withType_toGroovy() {
        val name = "tool_name".strSingle()
        val type = "mytype".strDouble()
        val expected = "tool name: ${name.toGroovy()}, type: ${type.toGroovy()}\n"
        Tool(name = name, type = type).toGroovy(writer)
        assertEquals(expected, out.toString())
    }
}
