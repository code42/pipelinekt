package com.code42.jenkins.pipelinekt.internal.step.scripted

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.internal.step.declarative.Literal
import kotlin.test.Test
import kotlin.test.assertEquals

class DockerAgentTest : GroovyScriptTest() {

    @Test
    fun dockerWithRegistry_credentialsNull() {
        val url = "hello.url"
        val step = Literal("hello.literal")
        val expected = """
            script {
            ${writer.indentStr}docker.withRegistry('$url', null) {
            ${writer.indentStr.repeat(2)}${step.codeBlock}
            ${writer.indentStr}}
            }
            
            """.trimIndent()

        Docker.WithRegistry(url.strSingle(), null, step).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun dockerWithRegistry_withCreds() {
        val url = "hello.url"
        val creds = "my-creds"
        val step = Literal("hello.literal")
        val expected = """
            script {
            ${writer.indentStr}docker.withRegistry('$url', "$creds") {
            ${writer.indentStr.repeat(2)}${step.codeBlock}
            ${writer.indentStr}}
            }
            
            """.trimIndent()

        Docker.WithRegistry(url.strSingle(), creds.strDouble(), step).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun dockerWithServer_credentialsNull() {
        val url = "hello.url"
        val step = Literal("hello.literal")
        val expected = """
            script {
            ${writer.indentStr}docker.withServer('$url', null) {
            ${writer.indentStr.repeat(2)}${step.codeBlock}
            ${writer.indentStr}}
            }
            
            """.trimIndent()

        Docker.WithServer(url.strSingle(), null, step).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun dockerWithServer_withCreds() {
        val url = "hello.url"
        val creds = "my-creds"
        val step = Literal("hello.literal")
        val expected = """
            script {
            ${writer.indentStr}docker.withServer('$url', "$creds") {
            ${writer.indentStr.repeat(2)}${step.codeBlock}
            ${writer.indentStr}}
            }
            
            """.trimIndent()

        Docker.WithServer(url.strSingle(), creds.strDouble(), step).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun dockerWithTool() {
        val tool = "some-tool"
        val step = Literal("hello.literal")
        val expected = """
            script {
            ${writer.indentStr}docker.withTool('$tool') {
            ${writer.indentStr.repeat(2)}${step.codeBlock}
            ${writer.indentStr}}
            }
            
            """.trimIndent()

        Docker.WithTool(tool.strSingle(), step).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun dockerBuild() {
        val image = "c42/my-image:1.0.0".strSingle()
        val args = "-v /home/user:/home/user".strSingle()
        val expected = """
            |script {
            |${writer.indentStr}docker.build(${image.toGroovy()}, ${args.toGroovy()})
            |}
            |
        """.trimMargin()
        Docker.Build(image, args).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun dockerImage() {
        val image = "c42/my-image:1.0.0".strSingle()
        val expected = """
            |script {
            |${writer.indentStr}docker.image(${image.toGroovy()})
            |}
            |
        """.trimMargin()
        Docker.Image(image).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun dockerPull() {
        val image = "c42/my-image:1.0.0".strSingle()
        val args = "-v /home/user:/home/user".strSingle()
        val expected = """
            |script {
            |${writer.indentStr}docker.build(${image.toGroovy()}, ${args.toGroovy()})
            |${writer.indentStr.repeat(2)}.pull()
            |}
            |
        """.trimMargin()
        Docker.Build(image, args).pull().toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun dockerPush() {
        val image = "c42/my-image:1.0.0".strSingle()
        val args = "-v /home/user:/home/user".strSingle()
        val expected = """
            |script {
            |${writer.indentStr}docker.build(${image.toGroovy()}, ${args.toGroovy()})
            |${writer.indentStr.repeat(2)}.push()
            |}
            |
        """.trimMargin()
        Docker.Build(image, args).push().toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun dockerPushSpecifyTagAndForce() {
        val image = "c42/my-image:1.0.0".strSingle()
        val args = "-v /home/user:/home/user".strSingle()

        val expected = """
            |script {
            |${writer.indentStr}docker.build(${image.toGroovy()}, ${args.toGroovy()})
            |${writer.indentStr.repeat(2)}.push(${image.toGroovy()}, false)
            |}
            |
        """.trimMargin()
        Docker.Build(image, args).push(image, false.boolVar()).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun dockerTag() {
        val image = "c42/my-image:1.0.0".strSingle()
        val args = "-v /home/user:/home/user".strSingle()
        val expected = """
            |script {
            |${writer.indentStr}docker.build(${image.toGroovy()}, ${args.toGroovy()})
            |${writer.indentStr.repeat(2)}.tag()
            |}
            |
        """.trimMargin()
        Docker.Build(image, args).tag().toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun dockerTagSpecifyTagAndForce() {
        val image = "c42/my-image:1.0.0".strSingle()
        val args = "-v /home/user:/home/user".strSingle()

        val expected = """
            |script {
            |${writer.indentStr}docker.build(${image.toGroovy()}, ${args.toGroovy()})
            |${writer.indentStr.repeat(2)}.tag(${image.toGroovy()}, false)
            |}
            |
        """.trimMargin()
        Docker.Build(image, args).tag(image, false.boolVar()).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun dockerRun() {
        val image = "c42/my-image:1.0.0".strSingle()
        val args = "-v /home/user:/home/user".strSingle()
        val expected = """
            |script {
            |${writer.indentStr}docker.build(${image.toGroovy()}, ${args.toGroovy()})
            |${writer.indentStr.repeat(2)}.run('', "")
            |}
            |
        """.trimMargin()
        Docker.Build(image, args).run().toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun dockerRun_specifyArgs() {
        val image = "c42/my-image:1.0.0".strSingle()
        val args = "-v /home/user:/home/user".strSingle()

        val runArgs = "-p myrunargs".strSingle()
        val runCommand = "myCommand".strSingle()

        val expected = """
            |script {
            |${writer.indentStr}docker.build(${image.toGroovy()}, ${args.toGroovy()})
            |${writer.indentStr.repeat(2)}.run(${runArgs.toGroovy()}, ${runCommand.toGroovy()})
            |}
            |
        """.trimMargin()
        Docker.Build(image, args).run(runArgs, runCommand).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun dockerRunWith() {
        val image = "c42/my-image:1.0.0".strSingle()
        val args = "-v /home/user:/home/user".strSingle()
        val step = Literal("hello.literal")
        val expected = """
            |script {
            |${writer.indentStr}docker.build(${image.toGroovy()}, ${args.toGroovy()})
            |${writer.indentStr.repeat(2)}.withRun('') { container ->
            |${writer.indentStr.repeat(3)}${step.codeBlock}
            |${writer.indentStr.repeat(2)}}
            |}
            |
        """.trimMargin()
        Docker.Build(image, args).withRun(steps = step).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun dockerRunWith_specifyArgs() {
        val image = "c42/my-image:1.0.0".strSingle()
        val args = "-v /home/user:/home/user".strSingle()

        val step = Literal("hello.literal")

        val runArgs = "-p myrunargs".strSingle()
        val runCommand = "myCommand".strSingle()

        val expected = """
            |script {
            |${writer.indentStr}docker.build(${image.toGroovy()}, ${args.toGroovy()})
            |${writer.indentStr.repeat(2)}.withRun(${runArgs.toGroovy()}, ${runCommand.toGroovy()}) { container ->
            |${writer.indentStr.repeat(3)}${step.codeBlock}
            |${writer.indentStr.repeat(2)}}
            |}
            |
        """.trimMargin()

        Docker.Build(image, args).withRun(runArgs, runCommand, step).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun dockerInside() {
        val image = "c42/my-image:1.0.0".strSingle()
        val args = "-v /home/user:/home/user".strSingle()
        val step = Literal("hello.literal")
        val expected = """
            |script {
            |${writer.indentStr}docker.build(${image.toGroovy()}, ${args.toGroovy()})
            |${writer.indentStr.repeat(2)}.inside('') {
            |${writer.indentStr.repeat(3)}${step.codeBlock}
            |${writer.indentStr.repeat(2)}}
            |}
            |
        """.trimMargin()
        Docker.Build(image, args).inside(steps = step).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test
    fun dockeInside_specifyArgs() {
        val image = "c42/my-image:1.0.0".strSingle()
        val args = "-v /home/user:/home/user".strSingle()

        val step = Literal("hello.literal")

        val runArgs = "-p myrunargs".strSingle()

        val expected = """
            |script {
            |${writer.indentStr}docker.build(${image.toGroovy()}, ${args.toGroovy()})
            |${writer.indentStr.repeat(2)}.inside(${runArgs.toGroovy()}) {
            |${writer.indentStr.repeat(3)}${step.codeBlock}
            |${writer.indentStr.repeat(2)}}
            |}
            |
        """.trimMargin()

        Docker.Build(image, args).inside(runArgs, step).toGroovy(writer)
        assertEquals(expected, out.toString())
    }
}
