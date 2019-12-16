package com.code42.jenkins.pipelinekt.core

import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyScript

interface Parameter : GroovyScript {
    val name: Var.Literal.Str

    fun toXml(): String
}
