package com.code42.jenkins.pipelinekt.dsl.step.custom

import com.code42.jenkins.pipelinekt.core.credentials.SshUserPrivateKey
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.ext.environmentVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.dsl.step.declarative.withCredentials
import com.code42.jenkins.pipelinekt.dsl.step.declarative.withEnv

data class GitDsl(val gitSshCredentialsId: String) {
    fun DslContext<Step>.withGitSshCreds(steps: DslContext<Step>.() -> Unit) {
        val keyFileEnvVar = "SSH_KEY_FILE".environmentVar()
        withCredentials(SshUserPrivateKey(keyFileVariable = keyFileEnvVar, credentialsId = gitSshCredentialsId.strSingle())) {
            withEnv(mapOf("GIT_SSH_COMMAND" to "ssh -i $keyFileEnvVar -F /dev/null -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null"), steps)
        }
    }
}
