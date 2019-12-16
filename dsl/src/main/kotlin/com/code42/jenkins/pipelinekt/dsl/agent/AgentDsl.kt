package com.code42.jenkins.pipelinekt.dsl.agent

import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.internal.agent.Label

fun Label.and(other: Label): Label =
        Label("${this.label} && ${other.label}".strDouble())
