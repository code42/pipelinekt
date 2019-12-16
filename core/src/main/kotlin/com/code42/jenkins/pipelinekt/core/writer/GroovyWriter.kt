package com.code42.jenkins.pipelinekt.core.writer

import com.code42.jenkins.pipelinekt.core.vars.Var
import java.io.File
import java.io.PrintWriter

/**
 * A class that can be mapped to a jenkinsfile
 */
interface GroovyScript {
    fun toGroovy(writer: GroovyWriter)
}

/**
 * Jenkinsfile context.  The Jenkinsfile has rules for what can happen in either context
 */
sealed class Context {
    object Scripted : Context()
    object Declarative : Context()
}

/**
 * Writes a GroovyScript to a PrintWriter.
 *
 * @param writer destination to write to.
 * @param indent the level of indent, initizlized to 0
 * @param context declarative or scripted
 * @param indentStr
 */
data class GroovyWriter(val writer: PrintWriter, val indent: Int = 0, val context: Context = Context.Declarative, val indentStr: String = "  ") {
    companion object {
        fun forFile(file: File, indentStr: String = "  "): GroovyWriter {
            return GroovyWriter(file.printWriter(), 0, indentStr = indentStr)
        }
    }

    /**
     * Write a groovy step to the writer, will look like
     *
     * prefix { param ->
     *   ...body...
     * }
     */
    fun closure(prefix: String, body: (GroovyWriter) -> Unit, param: Var.Variable) {
        closure(listOf(prefix), body, param)
    }

    /**
     * Write a groovy step to the writer, will look like
     *
     * prefix {
     *   ...body...
     * }
     */
    fun closure(prefix: String, body: (GroovyWriter) -> Unit) {
        closure(listOf(prefix), body, null)
    }

    /**
     * Write a closure to the output.  will look like
     *
     * prefix0
     * prefix1
     * prefix2 { param ->
     *   body
     * }
     */
    fun closure(prefix: List<String>, body: (GroovyWriter) -> Unit, param: Var.Variable?) {
        prefix.take(prefix.size - 1).forEach { this.writeln(it) }
        writeln("${prefix.last()} {${param?.let { " ${it.toGroovy()} ->"} ?: ""}")
        body(this.inner())
        writeln("}")
    }

    /**
     * Write a closure to the output.  will look like
     *
     * prefix0
     * prefix1
     * prefix2 {
     *   body
     * }
     */
    fun closure(prefix: List<String>, body: (GroovyWriter) -> Unit) {
        closure(prefix, body, null)
    }

    /**
     * ensure scripted context
     */
    fun scripted(body: (GroovyWriter) -> Unit) {
        if (this.context == Context.Scripted) {
            body(this)
        } else {
            this.copy(context = Context.Scripted).closure("script", body)
        }
    }

    /**
     * Return a new GroovyWRiter that writes at one level of nested indentation
     */
    fun inner(): GroovyWriter {
        return this.copy(indent = indent + 1)
    }

    /**
     * Write a ln to the output
     *
     * @param string the line to write
     */
    fun writeln(string: String) {
        writer.printIndent()
        writer.appendln(string.replace("\n", "\n${this.indentStr.repeat(this.indent)}"))
        writer.flush()
    }

    /**
     * print the indent
     */
    private fun PrintWriter.printIndent() {
        if (indent > 0) {
            for (i in 1..indent) {
                this.append(indentStr)
            }
        }
    }
}
