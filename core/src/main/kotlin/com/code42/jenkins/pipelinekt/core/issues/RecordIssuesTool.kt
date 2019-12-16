package com.code42.jenkins.pipelinekt.core.issues

import com.code42.jenkins.pipelinekt.core.vars.Var

// TODO move implementations to internal and implement in dsl
sealed class RecordIssuesTool {
    abstract fun toGroovy(): String
    data class Spotbugs(val pattern: Var.Literal.Str, val id: Var.Literal.Str, val name: Var.Literal.Str) : RecordIssuesTool() {
        override fun toGroovy(): String {
            return "spotBugs(pattern: ${pattern.toGroovy()}, id: ${id.toGroovy()}, name: ${name.toGroovy()})"
        }
    }

    data class CheckStyle(val pattern: Var.Literal.Str, val id: Var.Literal.Str, val name: Var.Literal.Str) : RecordIssuesTool() {
        override fun toGroovy(): String {
            return "checkStyle(pattern: ${pattern.toGroovy()}, id: ${id.toGroovy()}, name: ${name.toGroovy()})"
        }
    }

    abstract class Custom : RecordIssuesTool()
}
