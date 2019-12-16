package com.code42.jenkins.pipelinekt.`var`

import com.code42.jenkins.pipelinekt.core.step.Void
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.internal.step.declarative.Literal
import kotlin.test.assertEquals
import org.junit.Test

class LiteralClosureTest {
    @Test
    fun emptyClosure() {
        val expected = "{ }"
        val actual = Var.Literal.Closure(Void).toGroovy()
        assertEquals(expected, actual)
    }
    @Test
    fun singleStep() {
        val step = Literal("literal step1")
        val expected = "{\n" +
                "  ${step.codeBlock}\n" +
                "}"
        val actual = Var.Literal.Closure(step).toGroovy()
        assertEquals(expected, actual)
    }
    @Test
    fun multiStep() {
        val step = Literal("literal step1")
        val step2 = Literal("second step")
        val expected = "{\n" +
                "  ${step.codeBlock}\n" +
                "  ${step2.codeBlock}\n" +
                "}"
        val actual = Var.Literal.Closure(step.andThen(step2)).toGroovy()
        assertEquals(expected, actual)
    }
}
