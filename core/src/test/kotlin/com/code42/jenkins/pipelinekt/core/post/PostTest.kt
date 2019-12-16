package com.code42.jenkins.pipelinekt.core.post

import com.code42.jenkins.pipelinekt.core.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.Post
import com.code42.jenkins.pipelinekt.core.TestStep
import kotlin.test.assertEquals
import org.junit.Test

class PostTest : GroovyScriptTest() {
    @Test fun emptyPost() {
        val post = Post()
        post.toGroovy(writer)
        assertEquals("", out.toString())
    }

    @Test fun postWithAlways() {
        val post = Post(always = TestStep("hello"))
        post.toGroovy(writer)
        val expected = "post {\n" +
                "\talways {\n" +
                "\t\thello\n" +
                "\t}\n" +
                "}\n"
        assertEquals(expected, out.toString())
    }
}
