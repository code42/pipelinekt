package com.code42.jenkins.pipelinekt.core.credentials

import com.code42.jenkins.pipelinekt.core.vars.Var

data class Text(val credentialsId: Var, val variable: Var.Literal.Str) : JenkinsCredentials {
    override fun toGroovy(): List<String> {
        return listOf("\$class: 'StringBinding',",
                "credentialsId: ${credentialsId.toGroovy()},",
                "variable: ${variable.toGroovy()}")
    }
}
