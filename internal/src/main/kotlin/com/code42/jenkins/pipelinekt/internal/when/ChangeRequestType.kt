package com.code42.jenkins.pipelinekt.internal.`when`

sealed class ChangeRequestType {
    object Id : ChangeRequestType()
    object Target : ChangeRequestType()
    object Branch : ChangeRequestType()
    object Fork : ChangeRequestType()
    object Url : ChangeRequestType()
    object Title : ChangeRequestType()
    object Author : ChangeRequestType()
    object AuthorDisplayName : ChangeRequestType()
    object AuthorEmail : ChangeRequestType()
}
