package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import org.junit.Test
import kotlin.test.assertEquals

class BatTest : GroovyScriptTest() {
    @Test fun noLabel_toGroovy() {
        val expected = "bat (script: './my/script.sh', returnStdout: false)\n"
        Bat("./my/script.sh".strSingle()).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test fun withLabelLabel_toGroovy() {
        val expected = "bat (script: './my/script.sh', returnStdout: true, label: 'a descriptions here')\n"
        Bat("./my/script.sh".strSingle(), true.boolVar(), "a descriptions here".strSingle()).toGroovy(writer)
        assertEquals(expected, out.toString())
    }
}
