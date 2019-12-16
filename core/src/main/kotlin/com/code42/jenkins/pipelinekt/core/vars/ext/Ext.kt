package com.code42.jenkins.pipelinekt.core.vars.ext

import com.code42.jenkins.pipelinekt.core.vars.Var

/**
 * convert to a Jenkinsfile environment var
 */
fun String.environmentVar(): Var.Environment = Var.Environment(this)
fun String.parameter(): Var.Variable = Var.Variable("params.$this")
fun String.groovyVariable(): Var.Variable = Var.Variable(this)
fun String.groovyField(): Var.Field = Var.Field(this)

fun Int.intVar(): Var.Literal.Int = Var.Literal.Int(this)
fun Boolean.boolVar(): Var.Literal.Bool = Var.Literal.Bool(this)

/**
 * convert to a Jenkinsfile single quoted string var
 */
fun String.strSingle(): Var.Literal.Str.Single = Var.Literal.Str.Single(this)
/**
 * convert to a Jenkinsfile double quoted string var
 */
fun String.strDouble(): Var.Literal.Str.Double = Var.Literal.Str.Double(this)

fun String.multline(): Var.Literal.Str.Multiline = Var.Literal.Str.Multiline(this)
/**
 * Inlines a literal groovy string; Be careful
 */
fun String.inline(): Var.Literal.Inline = Var.Literal.Inline(this)
