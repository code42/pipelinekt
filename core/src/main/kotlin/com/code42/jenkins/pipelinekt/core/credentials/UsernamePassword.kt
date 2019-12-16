package com.code42.jenkins.pipelinekt.core.credentials

import com.code42.jenkins.pipelinekt.core.vars.Var

data class UsernamePassword(val credentialsId: Var, val usernameVariable: Var.Literal.Str, val passwordVariable: Var.Literal.Str) : JenkinsCredentials {
    override fun toGroovy(): List<String> {
        return listOf("\$class: 'UsernamePasswordMultiBinding',",
                "credentialsId: ${credentialsId.toGroovy()},",
                "usernameVariable: ${usernameVariable.toGroovy()},",
                "passwordVariable: ${passwordVariable.toGroovy()}")
    }
}
