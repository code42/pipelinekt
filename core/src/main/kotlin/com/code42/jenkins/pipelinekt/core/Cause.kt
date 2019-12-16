package com.code42.jenkins.pipelinekt.core

import com.code42.jenkins.pipelinekt.core.vars.Var

sealed class Cause {
    abstract fun toGroovy(): String
    object SCMTrigger : Cause() {
        override fun toGroovy(): String = "'SCMTrigger'"
    }
    object TimerTrigger : Cause() {
        override fun toGroovy(): String = "'TimerTrigger'"
    }

    object UpstreamCause : Cause() {
        override fun toGroovy(): String = "'UpstreamCause'"
    }
    data class UserIdCause(val userId: Var.Literal.Str) : Cause() {
        override fun toGroovy(): String = "cause: 'UserIdCause', detail: ${userId.toGroovy()}"
    }
}
