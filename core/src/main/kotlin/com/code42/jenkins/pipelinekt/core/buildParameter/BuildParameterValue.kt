package com.code42.jenkins.pipelinekt.core.buildParameter

import com.code42.jenkins.pipelinekt.core.Parameter

interface BuildParameterValue {
    fun toGroovy(): String
    fun toParameterDefintion(): Parameter
}
