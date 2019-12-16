package com.code42.jenkins.pipelinekt.internal.step

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.step.Void
import com.code42.jenkins.pipelinekt.internal.step.declarative.Closure
import com.code42.jenkins.pipelinekt.internal.step.declarative.Literal
import kotlin.test.assertEquals
import org.junit.Test

class ClosureStepTest : GroovyScriptTest() {
    @Test fun emptyClosure() {
        val expected = "{ }\n"
        Closure(Void).toGroovy(writer)
        assertEquals(expected, out.toString())
    }
    @Test fun singleStep() {
        val step = Literal("literal step1")
        val expected = "{\n" +
                "\t${step.codeBlock}\n" +
                "}\n"
        Closure(step).toGroovy(writer)
        assertEquals(expected, out.toString())
    }
    @Test fun multiStep() {
        val step = Literal("literal step1")
        val step2 = Literal("second step")
        val expected = "{\n" +
                "\t${step.codeBlock}\n" +
                "\t${step2.codeBlock}\n" +
                "}\n"
        Closure(step.andThen(step2)).toGroovy(writer)
        assertEquals(expected, out.toString())
    }
}
