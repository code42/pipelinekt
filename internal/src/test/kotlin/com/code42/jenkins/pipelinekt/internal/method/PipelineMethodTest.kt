package com.code42.jenkins.pipelinekt.internal.method

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.method.PipelineMethod
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.internal.step.declarative.Echo
import kotlin.test.assertEquals
import org.junit.Test

class PipelineMethodTest : GroovyScriptTest() {

    val methodName = "myMethod"

    @Test
    fun method_methodWithNoArgs_ToGroovy() {
        val expected = "def $methodName() {\n" +
                "\techo 'hello'\n" +
                "}\n"
        PipelineMethod(methodName, Echo("hello".strSingle()))
                .toGroovy(writer)

        assertEquals(expected, out.toString())
    }

    @Test
    fun method_invocation_ToGroovy() {
        val expected = "$methodName()\n"

        PipelineMethod
                .invocation(PipelineMethod(methodName, Echo("hello".strSingle())))
                .toGroovy(writer)

        assertEquals(expected, out.toString())
    }
}
