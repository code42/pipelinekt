package com.code42.jenkins.pipelinekt.core.credentials

import com.code42.jenkins.pipelinekt.core.vars.Var

data class SshUserPrivateKey(
    val keyFileVariable: Var.Environment,
    val credentialsId: Var.Literal.Str,
    val passphraseVariable: Var.Environment? = null,
    val usernameVariable: Var.Environment? = null
) : JenkinsCredentials {
    override fun toGroovy(): List<String> {
        return listOf("\$class: 'SSHUserPrivateKeyBinding',",
                "credentialsId: ${credentialsId.toGroovy()},",
                "keyFileVariable: '${keyFileVariable.name}',",
                usernameVariable?.let { "usernameVariable: '${it.name}'," },
                passphraseVariable?.let { "passphraseVariable: '${it.name}'" })
                .mapNotNull { it }
    }
}
