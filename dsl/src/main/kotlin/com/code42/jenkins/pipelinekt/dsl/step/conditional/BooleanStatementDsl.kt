package com.code42.jenkins.pipelinekt.dsl.step.conditional

import com.code42.jenkins.pipelinekt.core.conditional.BooleanStatement
import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.step.Void
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.core.writer.ext.toStep
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.scripted.If

@Suppress("UnusedPrivateMember")
fun DslContext<Step>.`if`(statement: BooleanStatement, then: DslContext<Step>.() -> Unit, `else`: DslContext<Step>.() -> Unit = { Void }) {
    condition(statement, then, `else`)
}

@Suppress("UnusedPrivateMember")
fun DslContext<Step>.`if`(statement: () -> BooleanStatement, then: DslContext<Step>.() -> Unit, `else`: DslContext<Step>.() -> Unit = { Void }) {
    condition(statement, then, `else`)
}
fun DslContext<Step>.condition(
    statement: () -> BooleanStatement,
    ifTrue: DslContext<Step>.() -> Unit,
    otherwise: DslContext<Step>.() -> Unit = { Void },
) {
    condition(statement(), ifTrue, otherwise)
}
fun DslContext<Step>.condition(statement: BooleanStatement, ifTrue: DslContext<Step>.() -> Unit, otherwise: DslContext<Step>.() -> Unit = { Void }) {
    val ifTrueSteps = DslContext.into(ifTrue).toStep()
    val ifFalseSteps = DslContext.into(otherwise).toStep()
    add(If(statement, ifTrueSteps, ifFalseSteps))
}

fun and(left: Var, right: Var): BooleanStatement = BooleanStatement.BinaryOperator.And(
    BooleanStatement.Variable(left),
    BooleanStatement.Variable(right),
)
fun and(left: BooleanStatement, right: BooleanStatement): BooleanStatement = BooleanStatement.BinaryOperator.And(left, right)

@Suppress("FunctionName")
infix fun Var.`&&`(other: Var): BooleanStatement = and(this, other)

@Suppress("FunctionName")
infix fun Var.`&&`(other: BooleanStatement): BooleanStatement = and(this.statement(), other)

@Suppress("FunctionName")
infix fun BooleanStatement.`&&`(other: BooleanStatement): BooleanStatement = and(this, other)

@Suppress("FunctionName")
infix fun BooleanStatement.`&&`(other: Var): BooleanStatement = and(this, other.statement())

fun or(left: Var, right: Var): BooleanStatement = BooleanStatement.BinaryOperator.Or(
    BooleanStatement.Variable(left),
    BooleanStatement.Variable(right),
)
fun or(left: BooleanStatement, right: BooleanStatement): BooleanStatement = BooleanStatement.BinaryOperator.Or(left, right)

@Suppress("FunctionName")
infix fun Var.`||`(other: Var): BooleanStatement = or(this, other)

@Suppress("FunctionName")
infix fun Var.`||`(other: BooleanStatement): BooleanStatement = or(this.statement(), other)

@Suppress("FunctionName")
infix fun BooleanStatement.`||`(other: BooleanStatement) = or(this, other)

@Suppress("FunctionName")
infix fun BooleanStatement.`||`(other: Var) = or(this, other.statement())

fun equal(left: Var, right: Var): BooleanStatement = BooleanStatement.BinaryOperator.Equals(
    BooleanStatement.Variable(left),
    BooleanStatement.Variable(right),
)
fun equal(left: BooleanStatement, right: BooleanStatement): BooleanStatement = BooleanStatement.BinaryOperator.Equals(left, right)

@Suppress("FunctionName")
infix fun String.`==`(other: String): BooleanStatement = equal(this.strDouble(), other.strDouble())

@Suppress("FunctionName")
infix fun String.`==`(other: Var): BooleanStatement = equal(this.strDouble(), other)

@Suppress("FunctionName")
infix fun Var.`==`(other: String): BooleanStatement = equal(this, other.strDouble())

@Suppress("FunctionName")
infix fun Var.`==`(other: Var): BooleanStatement = equal(this, other)

@Suppress("FunctionName")
infix fun String.`==`(other: BooleanStatement): BooleanStatement = equal(this.strDouble().statement(), other)

@Suppress("FunctionName")
infix fun BooleanStatement.`==`(other: String) = equal(this, other.strDouble().statement())

@Suppress("FunctionName")
infix fun BooleanStatement.`==`(other: BooleanStatement) = equal(this, other)

fun not(variable: Var): BooleanStatement = BooleanStatement.Not(BooleanStatement.Variable(variable))
fun not(statement: BooleanStatement): BooleanStatement = BooleanStatement.Not(statement)

@Suppress("FunctionName")
fun `!`(variable: Var): BooleanStatement = not(variable)

@Suppress("FunctionName")
fun `!`(statement: BooleanStatement): BooleanStatement = not(statement)

fun Var.statement(): BooleanStatement = BooleanStatement.Variable(this)
