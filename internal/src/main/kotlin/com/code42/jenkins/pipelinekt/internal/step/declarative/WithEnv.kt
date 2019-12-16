package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.NestedStep
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter
import com.code42.jenkins.pipelinekt.core.writer.ext.allButLast

/**
 * Make environment variables available to steps
 *
 * Does not use Var.Literal.Str because quotes are not needed in this bit of groovy.  It isn't a literal var
 *
 * @envs the environment variables to inject.
 * @steps the steps that can use the environment variables
 */
data class WithEnv(val envs: Map<String, String> = emptyMap(), override val steps: Step) : DeclarativeStep, NestedStep {
    companion object {

        /**
         * Produces withEnv block where values are inerpolated
         *
         * @param envs Map of environment variable name to interpolated values
         */
        fun ofConstToVar(envs: Map<String, Var>, steps: Step): WithEnv {
            return WithEnv(envs.mapValues { it.value.interpolated() }, steps)
        }

        /**
         * Produces withEnv block where both environment variable name and value are inerpolated
         *
         * @param envs Map of environment inerpolated variable name to interpolated environment variable values
         */
        fun ofVarToVar(envs: Map<Var, Var>, steps: Step): WithEnv {
            val envs = envs
                    .mapKeys { it.key.interpolated() }
                    .mapValues { it.value.interpolated() }
            return WithEnv(envs, steps)
        }
    }

    override fun toGroovy(writer: GroovyWriter) {
        val envsList = envs
                .map { (k, v) -> "\t\"$k=${v}\"" }
                .allButLast { str -> "$str," }

        writer.closure(listOf("withEnv([") + envsList + "])", steps::toGroovy)
    }
}
