package com.code42.jenkins.pipelinekt.dsl.stage

import com.code42.jenkins.pipelinekt.core.stage.MatrixAxis
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.dsl.DslContext
import java.util.Queue
import java.util.concurrent.LinkedBlockingQueue

data class MatrixAxisContext(val axes: Queue<MatrixAxis> = LinkedBlockingQueue()) : DslContext<MatrixAxis>(axes) {
    fun axis(name: String, values: String) {
        axis(name.strDouble(), values.strDouble())
    }
    fun axis(name: String, values: List<String>) {
        axis(name.strDouble(), values.map { it.strDouble() })
    }
    fun axis(name: Var.Literal.Str, values: Var.Literal.Str) {
        add(MatrixAxis(name, listOf(values)))
    }
    fun axis(name: Var.Literal.Str, values: List<Var.Literal.Str>) {
        add(MatrixAxis(name, values))
    }
}
