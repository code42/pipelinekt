package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.artifactory.RTSpec
import com.code42.jenkins.pipelinekt.core.artifactory.RTSpecFileProperties
import com.google.gson.GsonBuilder
import kotlin.test.assertEquals
import org.junit.Test

class RTSpecTest : GroovyScriptTest() {
    @Test fun specObjectConvertsToJSON() {
        val expected =
                """{
                    |  "files": [
                    |    {
                    |      "pattern": "breakfast/*waffles*.zip",
                    |      "target": "breakfast-repo/waffle-files/"
                    |    }
                    |  ]
                |}""".trimMargin()
        val gson = GsonBuilder().setPrettyPrinting().create()
        val filesSpec = RTSpec(listOf<RTSpecFileProperties>(
                RTSpecFileProperties("breakfast/*waffles*.zip", "breakfast-repo/waffle-files/")
        ))
        val jsonFilesSpec: String = gson.toJson((filesSpec))

        assertEquals(expected, jsonFilesSpec)
    }

    @Test fun specObjectMultipleFilePropertiesToJSON() {
        val expected =
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
        val gson = GsonBuilder().setPrettyPrinting().create()
        val filesSpec = RTSpec(listOf<RTSpecFileProperties>(
                RTSpecFileProperties("breakfast/*waffles*.zip", "breakfast-repo/waffle-files/"),
                RTSpecFileProperties("dinner/*steak*.zip", "dinner-repo/steak-files/")
        ))
        val jsonFilesSpec: String = gson.toJson((filesSpec))

        assertEquals(expected, jsonFilesSpec)
    }
}
