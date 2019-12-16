package com.code42.jenkins.pipelinekt.internal.`when`

import com.code42.jenkins.pipelinekt.core.Comparator
import com.code42.jenkins.pipelinekt.core.When
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter

sealed class ChangeRequest : When {
    abstract val name: String
    abstract val comparator: Comparator
    abstract val value: Var.Literal.Str

    override fun toGroovy(writer: GroovyWriter) {
        writer.writeln("changeRequest $name: ${value.toGroovy()}, comparator: ${comparator.toGroovy()}")
    }

    data class Id(override val value: Var.Literal.Str, override val comparator: Comparator) : ChangeRequest() {
        override val name = "id"
    }
    data class Target(override val value: Var.Literal.Str, override val comparator: Comparator) : ChangeRequest() {
        override val name = "target"
    }
    data class Branch(override val value: Var.Literal.Str, override val comparator: Comparator) : ChangeRequest() {
        override val name = "branch"
    }
    data class Fork(override val value: Var.Literal.Str, override val comparator: Comparator) : ChangeRequest() {
        override val name = "fork"
    }
    data class Url(override val value: Var.Literal.Str, override val comparator: Comparator) : ChangeRequest() {
        override val name = "url"
    }
    data class Title(override val value: Var.Literal.Str, override val comparator: Comparator) : ChangeRequest() {
        override val name = "title"
    }
    data class Author(override val value: Var.Literal.Str, override val comparator: Comparator) : ChangeRequest() {
        override val name = "author"
    }
    data class AuthorDisplayName(override val value: Var.Literal.Str, override val comparator: Comparator) : ChangeRequest() {
        override val name = "authorDisplayName"
    }
    data class AuthorEmail(override val value: Var.Literal.Str, override val comparator: Comparator) : ChangeRequest() {
        override val name = "authorEmail"
    }
}
