package com.code42.jenkins.pipelinekt.dsl.step.declarative

import com.code42.jenkins.pipelinekt.core.notifications.RecipientProvider
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.declarative.EmailExt

fun DslContext<Step>.emailExt(
    subject: Var.Literal.Str,
    body: Var.Literal.Str,
    emailRecipients: Var.Literal.Str? = null,
    recipientProviders: List<RecipientProvider>? = null
) =
    add(EmailExt(subject = subject,
            body = body,
            emailRecipients = emailRecipients,
            recipientProviders = recipientProviders))
