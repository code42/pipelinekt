package com.code42.jenkins.pipelinekt.core.method

import com.code42.jenkins.pipelinekt.core.vars.Var

data class PipelineMethodException(
    val invocationValues: Map<Var.Field, Var>,
    override val message: String
) : Exception()
