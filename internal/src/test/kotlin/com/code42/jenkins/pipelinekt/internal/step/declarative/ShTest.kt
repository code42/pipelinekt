package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import kotlin.test.assertEquals
import org.junit.Test

class ShTest : GroovyScriptTest() {
    @Test fun noLabel_toGroovy() {
        val expected = "sh (script: './my/script.sh', returnStdout: false)\n"
        Sh("./my/script.sh".strSingle()).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test fun withLabelLabel_toGroovy() {
        val expected = "sh (script: './my/script.sh', returnStdout: true, label: 'a descriptions here')\n"
        Sh("./my/script.sh".strSingle(), true.boolVar(), "a descriptions here".strSingle()).toGroovy(writer)
        assertEquals(expected, out.toString())
    }
}
