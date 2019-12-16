package com.code42.jenkins.pipelinekt.internal.method

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.method.PipelineMethodInvocation
import kotlin.test.assertEquals
import org.junit.Test

class PipelineMethodInvocationTest : GroovyScriptTest() {
    @Test fun test_toGroovy() {
        val name = "myMethod"
        PipelineMethodInvocation(name).toGroovy(writer)
        assertEquals("$name()\n", out.toString())
    }
}
