package com.code42.jenkins.pipelinekt.core.credentials

interface JenkinsCredentials {
    fun toGroovy(): List<String>
}
