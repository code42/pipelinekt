package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.secrets.VaultSecret
import com.code42.jenkins.pipelinekt.core.secrets.VaultSecrets
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import org.junit.Test
import kotlin.test.assertEquals

class WithVaultTest : GroovyScriptTest() {
    @Test
    fun defaults_toGroovy() {
        /*
        val expected = "withVault([\n" +
                "    vaultSecrets: [[path: 'some/vault/path', engineVersion: 1, secretValues: [\n" +
                "        [envVar: 'VAR_1', vaultKey: 'KEY_1']\n" +
                "    ]]]\n" +
                "]) {\n" +
                "${indentStr}sh (script: \"echo test\", returnStdout: false)\n" +
                "}\n"
        val secrets1 = VaultSecrets(
            path = "some/vault/path",
            engineVersion = "1",
            secrets = listOf(
                VaultSecret(envVar = "VAR_1", vaultKey = "KEY_1")
            )
        )
        WithVault(secrets = secrets1, steps = Sh("echo test".strDouble())).toGroovy(writer)
        assertEquals(expected, out.toString())
        */
    }
}