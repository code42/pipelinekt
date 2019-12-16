package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.vars.ext.environmentVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.internal.buildParameter.StringBuildParameterValue
import kotlin.test.assertEquals
import org.junit.Test

class BuildTest : GroovyScriptTest() {
    @Test fun buildNoParameters() {
        val expected = "build([\n" +
                "${writer.indentStr}job: \"my_downstream_job\",\n" +
                "${writer.indentStr}parameters: [],\n" +
                "${writer.indentStr}wait: true\n" +
                "])\n"
        Build("my_downstream_job".strDouble(), emptyList(), true.boolVar()).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test fun buildOneParameter() {
        val expected = "build([\n" +
                "${writer.indentStr}job: \"my_downstream_job\",\n" +
                "${writer.indentStr}parameters: [[\$class: 'hudson.model.StringParameterValue', name: 'COMMIT_HASH', value: env.GIT_COMMIT]],\n" +
                "${writer.indentStr}wait: true\n" +
                "])\n"
        Build("my_downstream_job".strDouble(), listOf(StringBuildParameterValue("COMMIT_HASH".strSingle(), "GIT_COMMIT".environmentVar())), true.boolVar()).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test fun buildManyParameters() {
        val expected = "build([\n" +
                "${writer.indentStr}job: \"my_downstream_job\",\n" +
                "${writer.indentStr}parameters: [[\$class: 'hudson.model.StringParameterValue', name: 'COMMIT_HASH', value: env.GIT_COMMIT],\n" +
                "${writer.indentStr}${writer.indentStr}[\$class: 'hudson.model.StringParameterValue', name: 'EXT_BUILD_NUMBER', value: env.EXT_BUILD_NUMBER],\n" +
                "${writer.indentStr}${writer.indentStr}[\$class: 'hudson.model.StringParameterValue', name: 'BRANCH_NAME', value: env.GIT_BRANCH]],\n" +
                "${writer.indentStr}wait: true\n" +
                "])\n"
        Build("my_downstream_job".strDouble(), listOf(StringBuildParameterValue("COMMIT_HASH".strSingle(), "GIT_COMMIT".environmentVar()),
                StringBuildParameterValue("EXT_BUILD_NUMBER".strSingle(), "EXT_BUILD_NUMBER".environmentVar()),
                StringBuildParameterValue("BRANCH_NAME".strSingle(), "GIT_BRANCH".environmentVar())), true.boolVar()).toGroovy(writer)
        assertEquals(expected, out.toString())
    }
}
