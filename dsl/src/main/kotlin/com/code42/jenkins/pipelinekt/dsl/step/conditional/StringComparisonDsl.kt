package com.code42.jenkins.pipelinekt.dsl.step.conditional

import com.code42.jenkins.pipelinekt.core.conditional.BooleanStatement
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble

fun Var.containsSubstring(subString: Var): BooleanStatement.StringOperator.Contains = BooleanStatement.StringOperator.Contains(this, subString)
fun Var.startsWithSubstring(subString: Var): BooleanStatement.StringOperator.StartsWith = BooleanStatement.StringOperator.StartsWith(this, subString)
fun Var.endsWithSubstring(subString: Var): BooleanStatement.StringOperator.EndsWith = BooleanStatement.StringOperator.EndsWith(this, subString)
fun Var.containsSubstring(subString: String): BooleanStatement.StringOperator.Contains = BooleanStatement.StringOperator.Contains(this, subString.strDouble())
fun Var.startsWithSubstring(subString: String): BooleanStatement.StringOperator.StartsWith = BooleanStatement.StringOperator.StartsWith(this, subString.strDouble())
fun Var.endsWithSubstring(subString: String): BooleanStatement.StringOperator.EndsWith = BooleanStatement.StringOperator.EndsWith(this, subString.strDouble())
fun String.containsSubstring(subString: Var): BooleanStatement.StringOperator.Contains = BooleanStatement.StringOperator.Contains(this.strDouble(), subString)
fun String.startsWithSubstring(subString: Var): BooleanStatement.StringOperator.StartsWith = BooleanStatement.StringOperator.StartsWith(this.strDouble(), subString)
fun String.endsWithSubstring(subString: Var): BooleanStatement.StringOperator.EndsWith = BooleanStatement.StringOperator.EndsWith(this.strDouble(), subString)
