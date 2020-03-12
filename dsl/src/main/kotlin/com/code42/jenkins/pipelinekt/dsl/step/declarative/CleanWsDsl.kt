package com.code42.jenkins.pipelinekt.dsl.step.declarative

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.declarative.CleanWs

fun DslContext<Step>.cleanWs(deleteDirs: Boolean = false, disableDeferredWipeout: Boolean = false) =
        add(CleanWs(deleteDirs, disableDeferredWipeout))
