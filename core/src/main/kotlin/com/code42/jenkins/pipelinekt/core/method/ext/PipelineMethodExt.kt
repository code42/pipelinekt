package com.code42.jenkins.pipelinekt.core.method.ext

import com.code42.jenkins.pipelinekt.core.vars.Var

/**
 * Jenkinsfiles don't support the full groovy syntax for named arguments, sorting by
 * field name and always including all fields on invocation gets around this
 */
fun <T> Map<Var.Field, T>.sortByFieldName(): Map<Var.Field, T> = this.toSortedMap(compareBy { it.name })
