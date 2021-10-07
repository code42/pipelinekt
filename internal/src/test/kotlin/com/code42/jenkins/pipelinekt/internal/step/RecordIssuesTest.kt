package com.code42.jenkins.pipelinekt.internal.step

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.issues.RecordIssuesTool
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.internal.step.declarative.RecordIssues
import kotlin.test.assertEquals
import org.junit.Test

class RecordIssuesTest : GroovyScriptTest() {
    @Test fun recordSpotbugsIssue() {
        val name = "my name".strSingle()
        val id = "my-id".strSingle()
        val pattern = "my/includes,and/more".strSingle()

        val expected = "recordIssues enabledForFailure: true," +
                " aggregatingResults: true," +
                " tool: spotBugs(pattern: ${pattern.toGroovy()}," +
                " id: ${id.toGroovy()}," +
                " name: ${name.toGroovy()})\n"
        RecordIssues(true.boolVar(), RecordIssuesTool.Spotbugs(pattern, id, name)).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test fun recordCheckstyleIssue() {
        val name = "my name".strSingle()
        val id = "my-id".strSingle()
        val pattern = "my/includes,and/more".strSingle()

        val expected = "recordIssues enabledForFailure: true," +
                " aggregatingResults: true," +
                " tool: checkStyle(pattern: ${pattern.toGroovy()}," +
                " id: ${id.toGroovy()}," +
                " name: ${name.toGroovy()})\n"

        RecordIssues(true.boolVar(), RecordIssuesTool.CheckStyle(pattern, id, name)).toGroovy(writer)
        assertEquals(expected, out.toString())
    }
}
