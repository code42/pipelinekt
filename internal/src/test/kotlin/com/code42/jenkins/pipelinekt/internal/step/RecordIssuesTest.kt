package com.code42.jenkins.pipelinekt.internal.step

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.issues.RecordIssuesTool
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.internal.step.declarative.RecordIssues
import org.junit.Test

class RecordIssuesTest : GroovyScriptTest() {
    @Test fun recordSpotbugsIssue() {
        val name = "my name".strSingle()
        val id = "my-id".strSingle()
        val pattern = "my/includes,and/more".strSingle()

        val expected = "recordIssues enabledForFailure: true, aggregateResults: true, tool: spotbugs(pattern: ${pattern.toGroovy()}, id: ${id.toGroovy()}, name: ${name.toGroovy()})"
        RecordIssues(true.boolVar(), RecordIssuesTool.Spotbugs(pattern, id, name)).toGroovy(writer)
    }

    @Test fun recordCheckstyleIssue() {
        val name = "my name".strSingle()
        val id = "my-id".strSingle()
        val pattern = "my/includes,and/more".strSingle()

        val expected = "recordIssues enabledForFailure: true, aggregateResults: true, tool: checkStyle(pattern: ${pattern.toGroovy()}, id: ${id.toGroovy()}, name: ${name.toGroovy()})"
        RecordIssues(true.boolVar(), RecordIssuesTool.Spotbugs(pattern, id, name)).toGroovy(writer)
    }
}
