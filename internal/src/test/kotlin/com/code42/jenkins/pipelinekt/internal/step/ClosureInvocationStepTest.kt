package com.code42.jenkins.pipelinekt.internal.step

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.groovyVariable
import com.code42.jenkins.pipelinekt.core.vars.ext.intVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.internal.step.declarative.ClosureInvocation
import kotlin.test.assertEquals
import org.junit.Test

class ClosureInvocationStepTest : GroovyScriptTest() {
    @Test
    fun noArgs_toGroovy() {
        val name = "myClosure"
        val expected = "$name()\n"
        ClosureInvocation(name).toGroovy(writer)
        val actual = out.toString()
        assertEquals(expected, actual)
    }

    @Test
    fun oneArg_toGroovy() {
        val name = "myClosure"
        val args = listOf("hello".strSingle())
        val expected = "$name('hello')\n"
        ClosureInvocation(name, args).toGroovy(writer)
        val actual = out.toString()
        assertEquals(expected, actual)
    }

    @Test
    fun manyArgs_toGroovy() {
        val name = "myClosure"
        val arg1 = "hello".strSingle()
        val arg2 = "variable".groovyVariable()
        val arg3 = Var.ClosureInvocation("invocation", listOf("someStr".strDouble()))
        val arg4 = 12.intVar()

        val args = listOf(arg1, arg2, arg3, arg4)
        val expected = "$name('hello', variable, invocation(\"someStr\"), 12)\n"

        ClosureInvocation(name, args).toGroovy(writer)
        val actual = out.toString()
        assertEquals(expected, actual)
    }
}
