package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import kotlin.test.assertEquals
import org.junit.Test

class PublishHtmlStepTest : GroovyScriptTest() {
    @Test fun testPublishHtmlStep_ToGroovy() {
        val expected = "publishHTML target: [\n" +
                "${writer.indentStr}allowMissing: true,\n" +
                "${writer.indentStr}alwaysLinkToLastBuild: true,\n" +
                "${writer.indentStr}keepAll: true,\n" +
                "${writer.indentStr}reportDir: \"reportsDirectory\",\n" +
                "${writer.indentStr}reportFiles: \"reportFiles\",\n" +
                "${writer.indentStr}reportName: \"reportName\"\n" +
                "]\n"

        PublishHtml("reportsDirectory".strDouble(), "reportFiles".strDouble(), "reportName".strDouble()).toGroovy(writer)
        assertEquals(expected, out.toString())
    }
}
