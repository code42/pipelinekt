package com.code42.jenkins.pipelinekt.dsl.step.declarative

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.vars.Var
import com.code42.jenkins.pipelinekt.core.vars.ext.boolVar
import com.code42.jenkins.pipelinekt.core.vars.ext.strDouble
import com.code42.jenkins.pipelinekt.dsl.DslContext
import com.code42.jenkins.pipelinekt.internal.step.declarative.Stash
import com.code42.jenkins.pipelinekt.internal.step.declarative.Unstash

fun DslContext<Step>.unstash(name: String) =
        unstash(name = name.strDouble())

fun DslContext<Step>.unstash(name: Var.Literal.Str) =
        add(Unstash(name = name))

fun DslContext<Step>.stash(
    name: String,
    includes: String? = null,
    allowEmpty: Boolean? = null,
    excludes: String? = null,
    useDefaultExcludes: Boolean? = null
) =
        stash(name = name.strDouble(),
                allowEmpty = allowEmpty?.boolVar(),
                excludes = excludes?.strDouble(),
                includes = includes?.strDouble(),
                useDefaultExcludes = useDefaultExcludes?.boolVar())

fun DslContext<Step>.stash(
    name: Var.Literal.Str,
    allowEmpty: Var.Literal.Bool? = null,
    excludes: Var.Literal.Str? = null,
    includes: Var.Literal.Str? = null,
    useDefaultExcludes: Var.Literal.Bool? = null
) =
        add(Stash(name = name,
                allowEmpty = allowEmpty,
                excludes = excludes,
                includes = includes,
                useDefaultExcludes = useDefaultExcludes))
