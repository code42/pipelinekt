package com.code42.jenkins.pipelinekt.core.secrets

data class VaultSecret(val envVar: String, val vaultKey: String) {
    fun toGroovy(): String {
        return "[envVar: '$envVar', vaultKey: '$vaultKey']"
    }
}
