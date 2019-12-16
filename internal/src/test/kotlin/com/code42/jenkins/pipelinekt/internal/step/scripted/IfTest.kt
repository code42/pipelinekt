package com.code42.jenkins.pipelinekt.internal.step.scripted

import com.code42.jenkins.pipelinekt.core.conditional.BooleanStatement
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.vars.ext.environmentVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import kotlin.test.assertEquals
import org.junit.Test

class IfTest {
    @Test fun booleanOperator_equals() {
        val val1 = "myVar1".environmentVar()
        val val2 = "myVa2".strDouble()
        val statement = BooleanStatement.BinaryOperator.Equals(BooleanStatement.Variable(val1), BooleanStatement.Variable(val2))
        assertEquals("(env.myVar1) == (\"myVa2\")", statement.toGroovy())
    }

    @Test fun booleanOperator_and() {
        val val1 = "myVar1".environmentVar()
        val val2 = "myVa2".strDouble()
        val statement = BooleanStatement.BinaryOperator.And(
                BooleanStatement.BinaryOperator.Equals(BooleanStatement.Variable(val1), BooleanStatement.Variable(val2)),
                BooleanStatement.Variable(true.boolVar()))
        assertEquals("((env.myVar1) == (\"myVa2\")) && (true)", statement.toGroovy())
    }

    @Test fun booleanOperator_or() {
        val val1 = "myVar1".environmentVar()
        val val2 = "myVa2".strDouble()
        val statement = BooleanStatement.BinaryOperator.Or(
                BooleanStatement.BinaryOperator.Equals(BooleanStatement.Variable(val1), BooleanStatement.Variable(val2)),
                BooleanStatement.Variable(true.boolVar())

        )
        assertEquals("((env.myVar1) == (\"myVa2\")) || (true)", statement.toGroovy())
    }

    @Test fun stringOperator_contains() {
        val str1 = "myEnv".environmentVar()
        val str2 = "literl".strSingle()

        val statement = BooleanStatement.StringOperator.Contains(str1, str2)
        assertEquals("${str1.toGroovy()}.contains(${str2.toGroovy()})", statement.toGroovy())
    }
    @Test fun stringOperator_endsWith() {
        val str1 = "myEnv".environmentVar()
        val str2 = "literl".strSingle()

        val statement = BooleanStatement.StringOperator.EndsWith(str1, str2)
        assertEquals("${str1.toGroovy()}.endsWith(${str2.toGroovy()})", statement.toGroovy())
    }
    @Test fun stringOperator_startsWith() {
        val str1 = "myEnv".environmentVar()
        val str2 = "literl".strSingle()

        val statement = BooleanStatement.StringOperator.StartsWith(str1, str2)
        assertEquals("${str1.toGroovy()}.startsWith(${str2.toGroovy()})", statement.toGroovy())
    }
}
