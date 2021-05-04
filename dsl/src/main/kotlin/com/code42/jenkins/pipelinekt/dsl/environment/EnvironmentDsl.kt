package com.code42.jenkins.pipelinekt.dsl.environment

import com.code42.jenkins.pipelinekt.core.Environment
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.environment.EnvVar

fun DslContext<Environment>.envVar(name: String, value: String) {
    add(EnvVar(name, value))
}
