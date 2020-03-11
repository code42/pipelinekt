package com.code42.jenkins.pipelinekt.core.credentials

import com.code42.jenkins.pipelinekt.core.vars.ext.environmentVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import kotlin.test.assertEquals
import org.junit.Test

class JenkinsCredentialsTest {
    @Test fun usernameAndPassword() {
        val credentialsId = "my-creds".strSingle()
        val usernameVariable = "CREDS_USERNAME".strSingle()
        val passwordVariable = "CREDS_PASSWORD".strSingle()
        val expected = listOf(
                "\$class: 'UsernamePasswordMultiBinding',",
                "credentialsId: ${credentialsId.toGroovy()},",
                "usernameVariable: ${usernameVariable.toGroovy()},",
                "passwordVariable: ${passwordVariable.toGroovy()}")
        val actual = UsernamePassword(credentialsId, usernameVariable, passwordVariable).toGroovy()
        assertEquals(expected, actual)
    }

    @Test fun text() {
        val credentialsId = "my-creds".strSingle()
        val variable = "CREDS_USERNAME".strSingle()
        val expected = listOf(
                "\$class: 'StringBinding',",
                "credentialsId: ${credentialsId.toGroovy()},",
                "variable: ${variable.toGroovy()}")
        val actual = Text(credentialsId, variable).toGroovy()
        assertEquals(expected, actual)
    }

    @Test fun file() {
        val credentialsId = "my-creds".strSingle()
        val variable = "CREDS_USERNAME".strSingle()
        val expected = listOf(
                "\$class: 'FileBinding',",
                "credentialsId: ${credentialsId.toGroovy()},",
                "variable: ${variable.toGroovy()}")
        val actual = File(credentialsId, variable).toGroovy()
        assertEquals(expected, actual)
    }

    @Test fun userSshKey() {
        val credentialsId = "my-creds".strSingle()
        val usernameVariable = "CREDS_USERNAME".environmentVar()
        val passphraseVariable = "CREDS_PASSPHRASE".environmentVar()
        val keyFileVariable = "CREDS_KEYFILE".environmentVar()

        val actual = SshUserPrivateKey(keyFileVariable, credentialsId, passphraseVariable, usernameVariable).toGroovy()

        assertEquals(listOf("\$class: 'SSHUserPrivateKeyBinding',",
                "credentialsId: ${credentialsId.toGroovy()},",
                "keyFileVariable: '${keyFileVariable.name}',",
                "usernameVariable: '${usernameVariable.name}',",
                "passphraseVariable: '${passphraseVariable.name}'"), actual)
    }

    @Test fun userSshKeyWithDefaults() {
        val credentialsId = "my-creds".strSingle()
        val keyFileVariable = "CREDS_KEYFILE".environmentVar()

        val actual = SshUserPrivateKey(keyFileVariable, credentialsId).toGroovy()

        assertEquals(listOf("\$class: 'SSHUserPrivateKeyBinding',",
                "credentialsId: ${credentialsId.toGroovy()},",
                "keyFileVariable: '${keyFileVariable.name}',"), actual)
    }
}
