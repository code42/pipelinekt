package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.secrets.VaultSecret
import com.code42.jenkins.pipelinekt.core.secrets.VaultSecrets
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import kotlin.test.assertEquals
import org.junit.Test

class WithVaultTest : GroovyScriptTest() {
    @Test
    fun withVaultBlockTest_singleVar() {
        val expected1 = "withVault([\n" +
                "  vaultSecrets: [[path: \"some/vault/path\", engineVersion: 1, secretValues: [\n" +
                "    [envVar: 'ENV_VAR', vaultKey: 'VAULT_KEY']\n" +
                "  ]]]\n" +
                "]) {\n" +
                "${indentStr}sh (script: \"echo testing...\", returnStdout: false)\n" +
                "}\n"
        val secrets1 = VaultSecrets(
            path = "some/vault/path",
            engineVersion = "1",
            secrets = listOf(
                VaultSecret(envVar = "ENV_VAR", vaultKey = "VAULT_KEY")
            )
        )
        WithVault(secrets = secrets1, steps = Sh("echo testing...".strDouble())).toGroovy(writer)
        assertEquals(expected1, out.toString())
    }

    @Test
    fun withVaultBlockTest_multipleVars() {
        val expected1 = "withVault([\n" +
                "  vaultSecrets: [[path: \"some/vault/path\", engineVersion: 1, secretValues: [\n" +
                "    [envVar: 'ENV_VAR1', vaultKey: 'VAULT_KEY1'],\n" +
                "    [envVar: 'ENV_VAR2', vaultKey: 'VAULT_KEY2']\n" +
                "  ]]]\n" +
                "]) {\n" +
                "${indentStr}sh (script: \"echo testing...\", returnStdout: false)\n" +
                "}\n"
        val secrets1 = VaultSecrets(
            path = "some/vault/path",
            engineVersion = "1",
            secrets = listOf(
                VaultSecret(envVar = "ENV_VAR1", vaultKey = "VAULT_KEY1"),
                VaultSecret(envVar = "ENV_VAR2", vaultKey = "VAULT_KEY2")
            )
        )
        WithVault(secrets = secrets1, steps = Sh("echo testing...".strDouble())).toGroovy(writer)
        assertEquals(expected1, out.toString())
    }
}
