package com.code42.jenkins.pipelinekt.core.secrets

interface Secrets {
    fun toGroovy(): String
}
