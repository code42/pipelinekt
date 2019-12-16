package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.artifactory.RTSpec
import com.code42.jenkins.pipelinekt.core.artifactory.RTSpecFileProperties
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import kotlin.test.assertEquals
import org.junit.Test

class RTUploadTest : GroovyScriptTest() {
    @Test fun onlyServerID() {
        val expected = "rtUpload (\n" +
                "\tserverID: \"-123456789\",\n" +
                "\tfaliNoOp: false\n" +
                ")\n"
        RTUpload("-123456789".strDouble()).toGroovy(writer)
        val actual = out.toString()

        assertEquals(expected, actual)
    }

    @Test
    fun withBuidNameOptions() {
        val expected = "rtUpload (\n" +
                "\tserverID: \"-123456789\",\n" +
                "\tbuildName: \"SOME_BUILD_NAME\",\n" +
                "\tfaliNoOp: false\n" +
                ")\n"
        RTUpload("-123456789".strDouble(), "SOME_BUILD_NAME".strDouble()).toGroovy(writer)
        val actual = out.toString()

        assertEquals(expected, actual)
    }

    @Test
    fun withBuildNameOptionsAndSpecPath() {
        val expected = "rtUpload (\n" +
                "\tserverID: \"-123456789\",\n" +
                "\tbuildName: \"SOME_BUILD_NAME\",\n" +
                "\tfaliNoOp: false,\n" +
                "\tspecPath: \"SOME_SPEC_PATH\"\n" +
                ")\n"
        RTUpload("-123456789".strDouble(), "SOME_BUILD_NAME".strDouble(), null, false.boolVar(), null, "SOME_SPEC_PATH".strDouble()).toGroovy(writer)
        val actual = out.toString()

        assertEquals(expected, actual)
    }

    @Test
    fun withAllOptions() {
        val rtSpec =
            """{
                    |  "files": [
                    |    {
                    |      "pattern": "breakfast/*waffles*.zip",
                    |      "target": "breakfast-repo/waffle-files/"
                    |    },
                    |    {
                    |      "pattern": "dinner/*steak*.zip",
                    |      "target": "dinner-repo/steak-files/"
                    |    }
                    |  ]
                |}""".trimMargin()

        val filesSpec = RTSpec(listOf(
                RTSpecFileProperties("breakfast/*waffles*.zip", "breakfast-repo/waffle-files/"),
                RTSpecFileProperties("dinner/*steak*.zip", "dinner-repo/steak-files/")
        ))

        val expected = "rtUpload (\n" +
                "\tserverID: \"-123456789\",\n" +
                "\tbuildName: \"SOME_BUILD_NAME\",\n" +
                "\tbuildNumber: \"12\",\n" +
                "\tfaliNoOp: false,\n" +
                "\tspec: \"\"\"${rtSpec}\"\"\",\n" +
                "\tspecPath: \"SOME_SPEC_PATH\"\n" +
                ")\n"
        RTUpload("-123456789".strDouble(), "SOME_BUILD_NAME".strDouble(), "12".strDouble(), false.boolVar(), filesSpec, "SOME_SPEC_PATH".strDouble()).toGroovy(writer)
        val actual = out.toString()

        assertEquals(expected, actual)
    }
}
