package com.code42.jenkins.pipelinekt.dsl.method

import com.code42.jenkins.pipelinekt.core.method.PipelineMethod
sealed class PipelineMethodError(
    override val message: String,
    override val cause: Throwable?
) : RuntimeException() {
    data class DuplicateMethod(
        val existingMethod: PipelineMethod,
        val newMethod: PipelineMethod
    ) : PipelineMethodError("Two methods with the same name and different implementation were registered", null)
}
