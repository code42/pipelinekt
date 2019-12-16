package com.code42.jenkins.pipelinekt.dsl.method

import com.code42.jenkins.pipelinekt.core.method.PipelineMethod
class PipelineMethodRegistry {
    companion object {
        fun validate(newPipelineMethod: PipelineMethod, existingMethods: List<PipelineMethod>) {
            existingMethods.find { existingPipelineMethod -> existingPipelineMethod.name == newPipelineMethod.name }
                    ?.let { if (it == newPipelineMethod) null else it }
                    ?.let { throw PipelineMethodError.DuplicateMethod(it, newPipelineMethod) }
        }

        fun validate(newPipelineMethod: PipelineMethod, existingMethods: Map<String, PipelineMethod>) {
            existingMethods.get(newPipelineMethod.name)
                    ?.let { if (it == newPipelineMethod) null else it }
                    ?.let { throw PipelineMethodError.DuplicateMethod(it, newPipelineMethod) }
        }
    }
    private val methods: MutableMap<String, PipelineMethod> = mutableMapOf()

    fun methods(): List<PipelineMethod> = methods.values.toList()

    private fun validateMethod(method: PipelineMethod) {
        validate(method, methods)
    }

    fun registerMethod(method: PipelineMethod) {
        validateMethod(method)
        methods.putIfAbsent(method.name, method)
    }

    fun reset() = methods.clear()
}
