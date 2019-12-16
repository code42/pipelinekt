package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.groovyField
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter
import com.code42.jenkins.pipelinekt.core.writer.ext.toGroovy

data class Stash(
    val name: Var.Literal.Str,
    val allowEmpty: Var.Literal.Bool? = null,
    val excludes: Var.Literal.Str? = null,
    val includes: Var.Literal.Str? = null,
    val useDefaultExcludes: Var.Literal.Bool? = null
) : DeclarativeStep, SingletonStep {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("stash(")

        mapOf("name".groovyField() to name,
                "allowEmpty".groovyField() to allowEmpty,
                "excludes".groovyField() to excludes,
                "includes".groovyField() to includes,
                "useDefaultExcludes".groovyField() to useDefaultExcludes)
                .mapNotNull { (k, v) -> v?.let { k to v } }
                .toMap()
                .toGroovy(writer)
        writer.writeln(")")
    }
}
