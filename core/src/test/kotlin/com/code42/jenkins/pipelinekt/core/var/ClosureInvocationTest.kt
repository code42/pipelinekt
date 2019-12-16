package com.code42.jenkins.pipelinekt.core.`var`

import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.groovyVariable
import com.code42.jenkins.pipelinekt.core.vars.ext.intVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import kotlin.test.assertEquals
import org.junit.Test

class ClosureInvocationTest {
    @Test fun noArgs_toGroovy() {
        val name = "myClosure"
        val expected = "$name()"
        val actual = Var.ClosureInvocation(name).toGroovy()
        assertEquals(expected, actual)
    }

    @Test fun oneArg_toGroovy() {
        val name = "myClosure"
        val args = listOf("hello".strSingle())
        val expected = "$name('hello')"
        val actual = Var.ClosureInvocation(name, args).toGroovy()
        assertEquals(expected, actual)
    }

    @Test fun manyArgs_toGroovy() {
        val name = "myClosure"
        val arg1 = "hello".strSingle()
        val arg2 = "variable".groovyVariable()
        val arg3 = Var.ClosureInvocation("invocation", listOf("someStr".strDouble()))
        val arg4 = 12.intVar()

        val args = listOf(arg1, arg2, arg3, arg4)
        val expected = "$name('hello', variable, invocation(\"someStr\"), 12)"
        val actual = Var.ClosureInvocation(name, args).toGroovy()
        assertEquals(expected, actual)
    }
}
