package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.GroovyScriptTest
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import kotlin.test.assertEquals
import org.junit.Test

class MailTest : GroovyScriptTest() {
    @Test fun empty_email() {
        val expected = "mail to: ''," +
                " subject: ''," +
                " body: ''," +
                " from: ''," +
                " cc: ''," +
                " bcc: ''," +
                " replyTo: ''," +
                " mimeType: ''," +
                " charset: ''\n"

        Mail().toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test fun basic_email() {
        val expected = "mail to: 'test@example.com'," +
                " subject: 'Job Failure'," +
                " body: 'Jenkins job build failure!'," +
                " from: ''," +
                " cc: ''," +
                " bcc: ''," +
                " replyTo: ''," +
                " mimeType: ''," +
                " charset: ''\n"

        Mail("test@example.com".strSingle(),
                "Job Failure".strSingle(),
                "Jenkins job build failure!".strSingle()).toGroovy(writer)
        assertEquals(expected, out.toString())
    }

    @Test fun all_parameters_email() {
        val expected = "mail to: 'test@example.com'," +
                " subject: 'Job Failure'," +
                " body: 'Jenkins job build failure!'," +
                " from: 'jenkins@example.com'," +
                " cc: 'test2@example.com'," +
                " bcc: 'test3@example.com'," +
                " replyTo: 'jenkins2@example.com'," +
                " mimeType: 'text/plain', charset: 'UTF-8'\n"

        Mail("test@example.com".strSingle(),
                "Job Failure".strSingle(),
                "Jenkins job build failure!".strSingle(),
                "test2@example.com".strSingle(),
                "test3@example.com".strSingle(),
                "jenkins@example.com".strSingle(),
                "jenkins2@example.com".strSingle(),
                "text/plain".strSingle(),
                "UTF-8".strSingle()).toGroovy(writer)
        assertEquals(expected, out.toString())
    }
}
