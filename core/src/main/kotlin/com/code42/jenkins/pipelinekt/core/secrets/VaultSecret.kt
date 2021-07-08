package com.code42.jenkins.pipelinekt.core.secrets

/**
 * Represents a secret retrieved from Vault that will be available to steps executed
 * in the same context.
 *
 * @param envVar The environment variable that will store the value of the secret.
 * @param vaultKey The key that will be retrieved from Vault containing the secret.
 */
data class VaultSecret(val envVar: String, val vaultKey: String) {
    fun toGroovy(): String {
        return "[envVar: '$envVar', vaultKey: '$vaultKey']"
    }
}
