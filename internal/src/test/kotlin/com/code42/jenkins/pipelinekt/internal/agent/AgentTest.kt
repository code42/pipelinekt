package com.code42.jenkins.pipelinekt.internal.agent

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.agent.DockerAgent
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import kotlin.test.Test
import kotlin.test.assertEquals

class AgentTest : GroovyScriptTest() {
    @Test
    fun nodeGroovyIsWellFormatted() {
        val label = "mylabel".strSingle()
        val expected = "agent {\n\tlabel ${label.toGroovy()}\n}\n"
        Label(label).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test fun dockerImageGroovyIsWellFormatted() {
        val image = "myImage".strSingle()
        val expected = "agent {\n" +
                "\tdocker {\n" +
                "\t\timage ${image.toGroovy()}\n" +
                "\t}\n" +
                "}\n"
        DockerAgent.Image(image).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test fun dockerImageGroovyIsWellFormatted_AndIncludesAdditionalFields() {
        val image = "myImage".strSingle()
        val args = "-my args".strSingle()
        val label = "image-label:v1".strSingle()
        val registryUrl = "docker.io/".strSingle()
        val registryCredentialsId = "registry-creds".strSingle()
        val expected = "agent {\n" +
                "\tdocker {\n" +
                "\t\timage ${image.toGroovy()}\n" +
                "\t\targs ${args.toGroovy()}\n" +
                "\t\tlabel ${label.toGroovy()}\n" +
                "\t\tregistryUrl ${registryUrl.toGroovy()}\n" +
                "\t\tregistryCredentialsId ${registryCredentialsId.toGroovy()}\n" +
                "\t}\n" +
                "}\n"
        DockerAgent.Image(
                image = image,
                args = args,
                label = label,
                registryUrl = registryUrl,
                registryCredentialsId = registryCredentialsId).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test fun dockerFileGroovyIsWellFormatted() {
        val filename = "build.Dockerfile".strSingle()
        val expected = "agent {\n" +
                "\tdockerfile {\n" +
                "\t\tfilename ${filename.toGroovy()}\n" +
                "\t}\n" +
                "}\n"
        DockerAgent.File(filename).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test fun dockerFileGroovyIsWellFormatted_AndIncludesExtraArgs() {
        val filename = "build.Dockerfile".strSingle()
        val args = "-my args".strSingle()
        val label = "image-label:v1".strSingle()
        val registryUrl = "docker.io/".strSingle()
        val dir = "dockerfile/dir".strSingle()
        val additionalBuildArgs = "--build-arg version=1.2.3".strSingle()
        val registryCredentialsId = "registry-creds".strSingle()

        val expected = "agent {\n" +
                "\tdockerfile {\n" +
                "\t\tfilename ${filename.toGroovy()}\n" +
                "\t\targs ${args.toGroovy()}\n" +
                "\t\tadditionalBuildArgs ${additionalBuildArgs.toGroovy()}\n" +
                "\t\tdir ${dir.toGroovy()}\n" +
                "\t\tlabel ${label.toGroovy()}\n" +
                "\t\tregistryUrl ${registryUrl.toGroovy()}\n" +
                "\t\tregistryCredentialsId ${registryCredentialsId.toGroovy()}\n" +
                "\t}\n" +
                "}\n"
        DockerAgent.File(
                filename = filename,
                dir = dir,
                additionalBuildArgs = additionalBuildArgs,
                args = args,
                label = label,
                registryUrl = registryUrl,
                registryCredentialsId = registryCredentialsId).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun agentWithNodeAndLabel() {
        val node = Node("super".strSingle())
        val expected = """
            ${indentStr.repeat(2)}agent {
            ${indentStr.repeat(3)}node {
            ${indentStr.repeat(4)}label 'super'
            ${indentStr.repeat(3)}}
            ${indentStr.repeat(2)}}

        """.trimIndent().replace("\n", System.getProperty("line.separator"))

        node.toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun agentNodeWithCustomWorkSpace() {
        val node = Node("super".strSingle(), "/super/path".strSingle())
        val expected = """
            ${indentStr.repeat(2)}agent {
            ${indentStr.repeat(3)}node {
            ${indentStr.repeat(4)}label 'super'
            ${indentStr.repeat(4)}customWorkspace '/super/path'
            ${indentStr.repeat(3)}}
            ${indentStr.repeat(2)}}

        """.trimIndent().replace("\n", System.getProperty("line.separator"))

        node.toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun agentAny() {
        val any = Any
        val expected = """
            ${indentStr.repeat(2)}agent any

        """.trimIndent().replace("\n", System.getProperty("line.separator"))

        any.toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun agentNone() {
        val none = None
        val expected = """
            ${indentStr.repeat(2)}agent none

        """.trimIndent().replace("\n", System.getProperty("line.separator"))

        none.toGroovy(writer)
        assertEquals(expected, out.toString())
    }
}
