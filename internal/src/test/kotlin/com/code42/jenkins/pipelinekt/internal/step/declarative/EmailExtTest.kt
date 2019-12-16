package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.notifications.RecipientProvider
import com.code42.jenkins.pipelinekt.core.vars.ext.multline
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import kotlin.test.assertEquals
import org.junit.Test

class EmailExtTest : GroovyScriptTest() {
    @Test fun noEmailRecipients() {
        val expected = "emailext (\n\tsubject: \"Very important\",\n\tbody: \"Just kidding. Not important\",\n\trecipientProviders: [[\$class: 'CulpritsRecipientProvider'],[\$class: 'DevelopersRecipientProvider'],[\$class: 'RequesterRecipientProvider']]\n)\n".multline()
        val recipients = listOf<RecipientProvider>(RecipientProvider.Culprits, RecipientProvider.Devlopers, RecipientProvider.Requester)
        EmailExt("Very important".strDouble(), "Just kidding. Not important".strDouble(), null, recipients).toGroovy(writer)
        val actual = out.toString().multline()

        assertEquals(expected, actual)
    }

    @Test fun noRecipientProviders() {
        val expected = "emailext (\n\tsubject: \"Very important\",\n\tbody: \"Just kidding. Not important\",\n\tto: \"Bob\"\n)\n".multline()
        EmailExt("Very important".strDouble(), "Just kidding. Not important".strDouble(), "Bob".strDouble(), null).toGroovy(writer)
        val actual = out.toString().multline()

        assertEquals(expected, actual)
    }

    @Test fun hasEmailAndRecipientProviders() {
        val expected = "emailext (\n\tsubject: \"Very important\",\n\tbody: \"Just kidding. Not important\",\n\tto: \"Bob\",\n\trecipientProviders: [[\$class: 'CulpritsRecipientProvider'],[\$class: 'DevelopersRecipientProvider'],[\$class: 'RequesterRecipientProvider']]\n)\n".multline()
        val recipients = listOf<RecipientProvider>(RecipientProvider.Culprits, RecipientProvider.Devlopers, RecipientProvider.Requester)
        EmailExt("Very important".strDouble(), "Just kidding. Not important".strDouble(), "Bob".strDouble(), recipients).toGroovy(writer)
        val actual = out.toString().multline()

        assertEquals(expected, actual)
    }
}
