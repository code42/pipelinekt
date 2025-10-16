package com.code42.jenkins.pipelinekt.core.agent

import com.code42.jenkins.pipelinekt.core.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import org.junit.Test
import kotlin.test.assertEquals

class DockerAgentTest : GroovyScriptTest() {
    @Test
    fun dockerImage_Serializes_requiredFields() {
        val agent = DockerAgent.Image("my.image:123".strDouble())

        val expected = """
            agent {
            ${indentStr}docker {
            ${indentStr}${indentStr}image ${agent.image.toGroovy()}
            $indentStr}
            }
        """.trimIndent()

        agent.toGroovy(writer)
        assertEquals(expected, out.toString().trim())
    }

    @Test
    fun dockerImage_Serializes_allFields() {
        val agent = DockerAgent.Image(
            "my.image:123".strDouble(),
            "my args".strDouble(),
            "mylabel".strDouble(),
            "custom/worksapce".strDouble(),
            "https://custom.registry".strDouble(),
            "reg-creds".strDouble(),
            false.boolVar(),
        )

        val expected = """
            agent {
            ${indentStr}docker {
            ${indentStr}${indentStr}image ${agent.image.toGroovy()}
            ${indentStr}${indentStr}args ${agent.args!!.toGroovy()}
            ${indentStr}${indentStr}label ${agent.label!!.toGroovy()}
            ${indentStr}${indentStr}customWorkspace ${agent.customWorkspace!!.toGroovy()}
            ${indentStr}${indentStr}registryUrl ${agent.registryUrl!!.toGroovy()}
            ${indentStr}${indentStr}registryCredentialsId ${agent.registryCredentialsId!!.toGroovy()}
            ${indentStr}${indentStr}reuseNode ${agent.reuseNode!!.toGroovy()}
            $indentStr}
            }
        """.trimIndent()

        agent.toGroovy(writer)
        assertEquals(expected, out.toString().trim())
    }

    @Test
    fun dockerFile_Serializes_requiredFields() {
        val agent = DockerAgent.File("agent.Dockerfile".strDouble())

        val expected = """
            agent {
            ${indentStr}dockerfile {
            ${indentStr}${indentStr}filename ${agent.filename.toGroovy()}
            $indentStr}
            }
        """.trimIndent()

        agent.toGroovy(writer)
        assertEquals(expected, out.toString().trim())
    }

    @Test
    fun dockerFile_Serializes_allFields() {
        val agent = DockerAgent.File(
            "agent.Dockerfile".strDouble(),
            "ci/".strDouble(),
            "build args".strDouble(),
            "my args".strDouble(),
            "mylabel".strDouble(),
            "custom/worksapce".strDouble(),
            "https://custom.registry".strDouble(),
            "reg-creds".strDouble(),
            false.boolVar(),
        )

        val expected = """
            agent {
            ${indentStr}dockerfile {
            ${indentStr}${indentStr}filename ${agent.filename.toGroovy()}
            ${indentStr}${indentStr}args ${agent.args!!.toGroovy()}
            ${indentStr}${indentStr}additionalBuildArgs ${agent.additionalBuildArgs!!.toGroovy()}
            ${indentStr}${indentStr}dir ${agent.dir!!.toGroovy()}
            ${indentStr}${indentStr}label ${agent.label!!.toGroovy()}
            ${indentStr}${indentStr}customWorkspace ${agent.customWorkspace!!.toGroovy()}
            ${indentStr}${indentStr}registryUrl ${agent.registryUrl!!.toGroovy()}
            ${indentStr}${indentStr}registryCredentialsId ${agent.registryCredentialsId!!.toGroovy()}
            ${indentStr}${indentStr}reuseNode ${agent.reuseNode!!.toGroovy()}
            $indentStr}
            }
        """.trimIndent()

        agent.toGroovy(writer)
        assertEquals(expected, out.toString().trim())
    }
}
