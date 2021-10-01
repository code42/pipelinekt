package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strSingle
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 *
 * Simple step for sending email.
 *
 * @param to To email address list. Comma separated list of email addresses.
 * @param subject Email subject line.
 * @param body Email body.
 * @param cc CC email address list. Comma separated list of email addresses.
 * @param bcc BCC email address list. Comma separated list of email addresses.
 * @param from From email address. Defaults to the admin address globally configured for the Jenkins instance.
 * @param replyTo Reply-To email address. Defaults to the admin address globally configured for the Jenkins instance.
 * @param mimeType Email body MIME type. Defaults to text/plain.
 * @param charset Email body character encoding. Defaults to UTF-8.
 */
data class Mail(
    val to: Var.Literal.Str = "".strSingle(),
    val subject: Var.Literal.Str = "".strSingle(),
    val body: Var.Literal.Str = "".strSingle(),
    val cc: Var.Literal.Str = "".strSingle(),
    val bcc: Var.Literal.Str = "".strSingle(),
    val from: Var.Literal.Str = "".strSingle(),
    val replyTo: Var.Literal.Str = "".strSingle(),
    val mimeType: Var.Literal.Str = "".strSingle(),
    val charset: Var.Literal.Str = "".strSingle()
) : DeclarativeStep, SingletonStep {
    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("mail to: ${to.toGroovy()}, subject: ${subject.toGroovy()}, body: ${body.toGroovy()}, from: ${from.toGroovy()}, cc: ${cc.toGroovy()}, bcc: ${bcc.toGroovy()}, replyTo: ${replyTo.toGroovy()}, mimeType: ${mimeType.toGroovy()}, charset: ${charset.toGroovy()}")
    }
}
