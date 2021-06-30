package com.code42.jenkins.pipelinekt.core.secrets

import com.code42.jenkins.pipelinekt.core.GroovyScriptTest
import kotlin.test.Test
import kotlin.test.assertEquals

class SecretsTest : GroovyScriptTest() {
    @Test
    fun secretsBlockTest() {
        val secrets1 = VaultSecrets(
            path = "some/vault/path",
            engineVersion = "1",
            secrets = listOf(
                VaultSecret(envVar = "VAR_1", vaultKey = "KEY_1"),
                VaultSecret(envVar = "VAR_2", vaultKey = "KEY_2")
            )
        )

        val expected = "    vaultSecrets: [[path: 'some/vault/path', engineVersion: 1, secretValues: [\n" +
                "        [envVar: 'VAR_1', vaultKey: 'KEY_1'],\n" +
                "        [envVar: 'VAR_2', vaultKey: 'KEY_2']\n" +
                "    ]]]\n"
        val out = secrets1.toGroovy()
        assertEquals(expected, out)
    }
}
