package com.code42.jenkins.pipelinekt.dsl.step.scripted

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.scripted.Literal

fun DslContext<Step>.setBuildDisplayName(displayName: String) =
        add(Literal("currentBuild.displayName = \"${displayName}\""))
