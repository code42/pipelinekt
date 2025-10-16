package com.code42.jenkins.pipelinekt.core

import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter
import org.junit.Before
import java.io.PrintWriter
import java.io.StringWriter

abstract class GroovyScriptTest {
    var out: StringWriter = StringWriter()
    val indentStr = "\t"
    var writer: GroovyWriter = GroovyWriter(PrintWriter(out), 0, indentStr = indentStr)

    @Before
    fun before() {
        out = StringWriter()
        writer = GroovyWriter(PrintWriter(out), 0, indentStr = indentStr)
    }
}
