package com.code42.jenkins.pipelinekt.core.notifications

sealed class RecipientProvider {
    abstract fun toGroovy(): String
    object Culprits : RecipientProvider() {
        override fun toGroovy() = "[\$class: 'CulpritsRecipientProvider']"
    }
    object Devlopers : RecipientProvider() {
        override fun toGroovy() = "[\$class: 'DevelopersRecipientProvider']"
    }
    object BrokenTestsSuspects : RecipientProvider() {
        override fun toGroovy() = "[\$class: 'BrokenTestsSuspectsRecipientProvider']"
    }
    object BrokenBuildSuspects : RecipientProvider() {
        override fun toGroovy() = "[\$class: 'BrokenBuildSuspectsRecipientProvider']"
    }
    object Recipients : RecipientProvider() {
        override fun toGroovy() = "[\$class: 'RecipientsRecipientProvider']"
    }
    object Requester : RecipientProvider() {
        override fun toGroovy() = "[\$class: 'RequesterRecipientProvider']"
    }
    object UpstreamDevelopers : RecipientProvider() {
        override fun toGroovy() = "[\$class: 'UpstreamDevelopersRecipientProvider']"
    }

    abstract class Custom : RecipientProvider()
}
