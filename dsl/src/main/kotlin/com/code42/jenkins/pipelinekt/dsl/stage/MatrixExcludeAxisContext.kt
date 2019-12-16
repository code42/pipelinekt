package com.code42.jenkins.pipelinekt.dsl.stage

import com.code42.jenkins.pipelinekt.core.stage.ExcludeAxis
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.dsl.DslContext
import java.util.Queue
import java.util.concurrent.LinkedBlockingQueue

data class MatrixExcludeAxisContext(
    val excludeAxes: Queue<ExcludeAxis> = LinkedBlockingQueue()
) : DslContext<ExcludeAxis>(excludeAxes) {
    fun axis(name: String, values: String) {
        axis(name.strDouble(), values.strDouble())
    }
    fun axis(name: String, values: List<String>) {
        axis(name.strDouble(), values.map { it.strDouble() })
    }

    fun axis(name: Var.Literal.Str, values: Var.Literal.Str) {
        axis(name, listOf(values))
    }
    fun axis(name: Var.Literal.Str, values: List<Var.Literal.Str>) {
        add(ExcludeAxis.Values(name, values))
    }
    fun notAxis(name: String, notValues: String) {
        notAxis(name.strDouble(), notValues.strDouble())
    }
    fun notAxis(name: String, notValues: List<String>) {
        notAxis(name.strDouble(), notValues.map { it.strDouble() })
    }
    fun notAxis(name: Var.Literal.Str, notValues: Var.Literal.Str) {
        notAxis(name, listOf(notValues))
    }
    fun notAxis(name: Var.Literal.Str, notValues: List<Var.Literal.Str>) {
        add(ExcludeAxis.NotValues(name, notValues))
    }
}
