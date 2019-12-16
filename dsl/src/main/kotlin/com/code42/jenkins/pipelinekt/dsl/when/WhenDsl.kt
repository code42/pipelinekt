package com.code42.jenkins.pipelinekt.dsl.`when`

import com.code42.jenkins.pipelinekt.core.Cause
import com.code42.jenkins.pipelinekt.core.Comparator
import com.code42.jenkins.pipelinekt.core.When
import com.code42.jenkins.pipelinekt.core.conditional.BooleanStatement
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.vars.ext.environmentVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.dsl.SingletonDslContext
import com.code42.jenkins.pipelinekt.internal.`when`.AllOf
import com.code42.jenkins.pipelinekt.internal.`when`.AnyOf
import com.code42.jenkins.pipelinekt.internal.`when`.Before
import com.code42.jenkins.pipelinekt.internal.`when`.Branch
import com.code42.jenkins.pipelinekt.internal.`when`.BuildingTag
import com.code42.jenkins.pipelinekt.internal.`when`.ChangeRequest
import com.code42.jenkins.pipelinekt.internal.`when`.ChangeRequestType
import com.code42.jenkins.pipelinekt.internal.`when`.ChangeSet
import com.code42.jenkins.pipelinekt.internal.`when`.Changelog
import com.code42.jenkins.pipelinekt.internal.`when`.Environment
import com.code42.jenkins.pipelinekt.internal.`when`.Equals
import com.code42.jenkins.pipelinekt.internal.`when`.Expression
import com.code42.jenkins.pipelinekt.internal.`when`.Literal
import com.code42.jenkins.pipelinekt.internal.`when`.Tag
import com.code42.jenkins.pipelinekt.internal.`when`.TriggeredBy

fun DslContext<When>.branch(name: String) {
    branch(name.strDouble())
}

fun DslContext<When>.branch(name: Var.Literal.Str) {
    add(Branch.Name(name))
}

fun DslContext<When>.branch(pattern: String, comparator: Comparator) {
    branch(pattern.strDouble(), comparator)
}
fun DslContext<When>.branch(pattern: Var.Literal.Str, comparator: Comparator) {
    add(Branch.Pattern(pattern, comparator))
}

fun DslContext<When>.tag(name: String) {
    tag(name.strDouble())
}

fun DslContext<When>.tag(name: Var.Literal.Str) {
    add(Tag.Name(name))
}

fun DslContext<When>.tag(pattern: String, comparator: Comparator) {
    tag(pattern.strDouble(), comparator)
}
fun DslContext<When>.tag(pattern: Var.Literal.Str, comparator: Comparator) {
    add(Tag.Pattern(pattern, comparator))
}

fun DslContext<When>.buildingTag() {
    add(BuildingTag)
}

fun DslContext<When>.changelog(regex: String) {
    changelog(regex.strDouble())
}

fun DslContext<When>.changelog(regex: Var.Literal.Str) {
    add(Changelog(regex))
}

fun DslContext<When>.changeSet(glob: String, caseSensitive: Boolean) {
    changeSet(glob.strDouble(), caseSensitive.boolVar())
}

fun DslContext<When>.changeSet(glob: Var.Literal.Str, caseSensitive: Var.Literal.Bool) {
    add(ChangeSet(glob, caseSensitive))
}

fun DslContext<When>.changeRequest(changeRequestType: ChangeRequestType, value: String, comparator: Comparator) {
    changeRequest(changeRequestType, value.strDouble(), comparator)
}

fun DslContext<When>.changeRequest(changeRequestType: ChangeRequestType, value: Var.Literal.Str, comparator: Comparator) {
    add(when (changeRequestType) {
        ChangeRequestType.Id -> ChangeRequest.Id(value, comparator)
        ChangeRequestType.Target -> ChangeRequest.Target(value, comparator)
        ChangeRequestType.Branch -> ChangeRequest.Branch(value, comparator)
        ChangeRequestType.Fork -> ChangeRequest.Fork(value, comparator)
        ChangeRequestType.Url -> ChangeRequest.Url(value, comparator)
        ChangeRequestType.Title -> ChangeRequest.Title(value, comparator)
        ChangeRequestType.Author -> ChangeRequest.Author(value, comparator)
        ChangeRequestType.AuthorDisplayName -> ChangeRequest.AuthorDisplayName(value, comparator)
        ChangeRequestType.AuthorEmail -> ChangeRequest.AuthorEmail(value, comparator)
    })
}

fun DslContext<When>.environment(name: String, value: String) {
    environment(name.environmentVar(), value.strDouble())
}
fun DslContext<When>.environment(name: Var.Environment, value: Var.Literal.Str) {
    add(Environment(name, value))
}
fun DslContext<When>.equals(expected: Var, actual: Var) {
    add(Equals(expected, actual))
}

fun DslContext<When>.expression(statementBlock: () -> BooleanStatement) {
    add(Expression(statementBlock()))
}

fun DslContext<When>.not(notBlock: SingletonDslContext<When>.() -> Unit) {
    SingletonDslContext.into(notBlock)
            ?.let(this::add)
}

fun DslContext<When>.allOf(allOfBlock: DslContext<When>.() -> Unit) {
    DslContext.into(allOfBlock)
            ?.let { this.add(AllOf(it)) }
}

fun DslContext<When>.anyOf(anyOfBlock: DslContext<When>.() -> Unit) {
    DslContext.into(anyOfBlock)
            .let { AnyOf(it) }
            .let(this::add)
}

fun DslContext<When>.literal(codeBlock: String) {
    add(Literal(codeBlock))
}

fun DslContext<When>.triggeredBy(cause: Cause) {
    add(TriggeredBy(cause))
}

fun DslContext<When>.beforeAgent(enabled: Boolean) {
    add(Before.Agent(enabled))
}

fun DslContext<When>.beforeInput(enabled: Boolean) {
    add(Before.Input(enabled))
}
