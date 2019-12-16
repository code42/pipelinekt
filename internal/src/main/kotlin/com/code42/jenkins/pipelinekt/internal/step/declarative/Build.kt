package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.buildParameter.BuildParameterValue
import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

data class Build(
    val job: Var,
    val parameters: List<BuildParameterValue>,
    val wait: Var.Literal.Bool
) : DeclarativeStep, SingletonStep {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("build([")
        writer.inner().let { inner ->
            inner.writeln("job: ${job.toGroovy()},")
            inner.writeln("parameters: [${parameters.map { it.toGroovy() }.joinToString(",\n${writer.indentStr}")}],")
            inner.writeln("wait: ${wait.toGroovy()}")
        }
        writer.writeln("])")
    }
}
