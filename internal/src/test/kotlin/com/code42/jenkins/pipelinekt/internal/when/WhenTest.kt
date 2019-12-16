package com.code42.jenkins.pipelinekt.internal.`when`

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.Cause
import com.code42.jenkins.pipelinekt.core.Comparator
import com.code42.jenkins.pipelinekt.core.conditional.BooleanStatement
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.vars.ext.environmentVar
import com.code42.jenkins.pipelinekt.core.vars.ext.intVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.core.writer.ext.toGroovy
import kotlin.test.Test
import kotlin.test.assertEquals

class WhenTest : GroovyScriptTest() {

    @Test
    fun whenBranch() {
        val whenBlock = Branch.Name("master".strSingle())
        val expected = """
            ${indentStr.repeat(2)}branch 'master'

        """.trimIndent().replace("\n", System.getProperty("line.separator"))
        whenBlock.toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun whenChangeLog() {
        val whenBlock = Changelog("\\d+".strSingle())
        val expected = """
            ${indentStr.repeat(2)}changelog '\d+'

        """.trimIndent().replace("\n", System.getProperty("line.separator"))
        whenBlock.toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun whenChangeSetCaseSensitive() {
        val whenBlock = ChangeSet("**\\*.java".strSingle(), true.boolVar())
        val expected = """
            ${indentStr.repeat(2)}changeset glob: '**\*.java', caseSensitive: true

        """.trimIndent().replace("\n", System.getProperty("line.separator"))
        whenBlock.toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun whenChangeRequestAuthorEquals() {
        val whenBlock = ChangeRequest.Author("sample".strSingle(), Comparator.Equals)
        val expected = """
            ${indentStr.repeat(2)}changeRequest author: 'sample', comparator: 'EQUALS'

        """.trimIndent().replace("\n", System.getProperty("line.separator"))
        whenBlock.toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun whenEnvironment() {
        val whenBlock = Environment("prod".environmentVar(), "uction".strSingle())
        val expected = """
            ${indentStr.repeat(2)}environment name: env.prod, value: 'uction'

        """.trimIndent().replace("\n", System.getProperty("line.separator"))
        whenBlock.toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun whenEquals() {
        val whenBlock = Equals("prod".strSingle(), "prod".strSingle())
        val expected = """
            ${indentStr.repeat(2)}equals expected: 'prod', actual: 'prod'

        """.trimIndent().replace("\n", System.getProperty("line.separator"))
        whenBlock.toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun whenExpression() {
        val whenBlock = Expression(BooleanStatement.Literal("./the_thing.sh"))
        val expected = """
            ${indentStr.repeat(2)}expression {
            ${indentStr.repeat(3)}./the_thing.sh
            ${indentStr.repeat(2)}}

        """.trimIndent().replace("\n", System.getProperty("line.separator"))
        whenBlock.toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun whenTag() {
        val whenBlock = Tag.Pattern("release/7.*".strSingle(), Comparator.Equals)
        val expected = """
            ${indentStr.repeat(2)}tag pattern: 'release/7.*', comparator: 'EQUALS'

        """.trimIndent().replace("\n", System.getProperty("line.separator"))
        whenBlock.toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun whenNot() {
        var x = 1

        val whenBlock = Not(Expression(BooleanStatement.Variable(x.intVar())))
        val expected = """
            ${indentStr.repeat(2)}not {
            ${indentStr.repeat(3)}expression {
            ${indentStr.repeat(4)}1
            ${indentStr.repeat(3)}}
            ${indentStr.repeat(2)}}

        """.trimIndent().replace("\n", System.getProperty("line.separator"))
        whenBlock.toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun whenAllOf() {
        var left = 1
        var right = 2

        val whenBlock = AllOf(listOf(
                Expression(BooleanStatement.StringOperator.EndsWith(left.intVar(), right.intVar()))
        ))
        val expected = """
            ${indentStr.repeat(2)}allOf {
            ${indentStr.repeat(3)}expression {
            ${indentStr.repeat(4)}1.endsWith(2)
            ${indentStr.repeat(3)}}
            ${indentStr.repeat(2)}}

        """.trimIndent().replace("\n", System.getProperty("line.separator"))
        whenBlock.toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun whenAnyOf() {
        var left = 1
        var right = 2

        val whenBlock = AnyOf(listOf(
                Expression(BooleanStatement.StringOperator.EndsWith(left.intVar(), right.intVar())),
                Branch.Name("Master".strSingle())
        ))
        val expected = """
            ${indentStr.repeat(2)}anyOf {
            ${indentStr.repeat(3)}expression {
            ${indentStr.repeat(4)}1.endsWith(2)
            ${indentStr.repeat(3)}}
            ${indentStr.repeat(3)}branch 'Master'
            ${indentStr.repeat(2)}}

        """.trimIndent().replace("\n", System.getProperty("line.separator"))
        whenBlock.toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun whenTriggeredByTimerTrigger() {
        val whenBlock = TriggeredBy(
                Cause.TimerTrigger
        )

        val expected = """
            ${indentStr.repeat(2)}triggeredBy 'TimerTrigger'

        """.trimIndent().replace("\n", System.getProperty("line.separator"))
        whenBlock.toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun whenTriggeredByUpstreamCause() {
        val whenBlock = TriggeredBy(
                Cause.UpstreamCause
        )

        val expected = """
            ${indentStr.repeat(2)}triggeredBy 'UpstreamCause'

        """.trimIndent().replace("\n", System.getProperty("line.separator"))
        whenBlock.toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun whenTriggeredBySCMTrigger() {
        val whenBlock = TriggeredBy(
                Cause.SCMTrigger
        )

        val expected = """
            ${indentStr.repeat(2)}triggeredBy 'SCMTrigger'

        """.trimIndent().replace("\n", System.getProperty("line.separator"))
        whenBlock.toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun whenBeforeAgentWithExpression() {
        val enabled = true
        val booleanDoTesting = BooleanStatement.Literal("Params.DO_TESTING")

        val whenBlock = listOf(
                Before.Agent(enabled),
                Expression(booleanDoTesting))

        val expected = """
            ${indentStr.repeat(2)}beforeAgent true
            ${indentStr.repeat(2)}expression {
            ${indentStr.repeat(3)}Params.DO_TESTING
            ${indentStr.repeat(2)}}

            """.trimIndent().replace("\n", System.getProperty("line.separator"))
        whenBlock.toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun whenBeforeInputWithExpression() {
        val enabled = true
        val booleanDoTesting = BooleanStatement.Literal("Params.DO_TESTING")

        val whenBlock = listOf(
                Before.Input(enabled),
                Expression(booleanDoTesting))

        val expected = """
            ${indentStr.repeat(2)}beforeInput true
            ${indentStr.repeat(2)}expression {
            ${indentStr.repeat(3)}Params.DO_TESTING
            ${indentStr.repeat(2)}}

            """.trimIndent().replace("\n", System.getProperty("line.separator"))
        whenBlock.toGroovy(writer)
        assertEquals(expected, out.toString())
    }
}
