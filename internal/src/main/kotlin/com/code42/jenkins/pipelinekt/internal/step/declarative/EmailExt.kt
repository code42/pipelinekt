package com.code42.jenkins.pipelinekt.internal.step.declarative

import com.code42.jenkins.pipelinekt.core.notifications.RecipientProvider
import com.code42.jenkins.pipelinekt.core.step.DeclarativeStep
import com.code42.jenkins.pipelinekt.core.step.SingletonStep
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

/**
 * Inject email into steps
 *
 * @param buildemail the build email to inject
 * @param steps the steps to inject
 */
data class EmailExt(
    val subject: Var.Literal.Str,
    val body: Var.Literal.Str,
    val emailRecipients: Var.Literal.Str? = null,
    val recipientProviders: List<RecipientProvider>? = null
) : DeclarativeStep, SingletonStep {

    override fun toGroovy(writer: GroovyWriter) {
        val rString = recipientProviders
                ?.map { it.toGroovy() }
                ?.joinToString(",")
                ?.let { "recipientProviders: [$it]" }

        val emailContent = listOf("${writer.indentStr}subject: ${subject.toGroovy()}",
                "body: ${body.toGroovy()}",
                (emailRecipients?.let { "to: ${it.toGroovy()}" }),
                (rString)
        ).filterNotNull().joinToString(",\n${writer.indentStr}")

        writer.writeln("emailext (\n${emailContent}\n)")
    }
}
