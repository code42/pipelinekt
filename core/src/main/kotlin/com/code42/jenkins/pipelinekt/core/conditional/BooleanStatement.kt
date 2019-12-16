package com.code42.jenkins.pipelinekt.core.conditional

import com.code42.jenkins.pipelinekt.core.vars.Var

sealed class BooleanStatement {
    abstract fun toGroovy(): String
    fun interpolated(): String = "\${${this.toGroovy()}}"
    final override fun toString(): String = interpolated()

    data class Literal(val script: String) : BooleanStatement() {
        override fun toGroovy(): String {
            return script
        }
    }

    data class Not(val statement: BooleanStatement) : BooleanStatement() {
        override fun toGroovy(): String {
            return "!(${statement.toGroovy()})"
        }
    }

    data class Variable(val variable: Var) : BooleanStatement() {
        override fun toGroovy(): String {
            return variable.toGroovy()
        }
    }

    sealed class BinaryOperator : BooleanStatement() {
        abstract val left: BooleanStatement
        abstract val right: BooleanStatement
        abstract val operator: String
        override fun toGroovy(): String {
            return "(${left.toGroovy()}) $operator (${right.toGroovy()})"
        }
        data class Equals(override val left: BooleanStatement, override val right: BooleanStatement) : BinaryOperator() {
            override val operator: String = "=="
        }
        data class And(override val left: BooleanStatement, override val right: BooleanStatement) : BinaryOperator() {
            override val operator: String = "&&"
        }
        data class Or(override val left: BooleanStatement, override val right: BooleanStatement) : BinaryOperator() {
            override val operator: String = "||"
        }
    }

    sealed class StringOperator : BooleanStatement() {
        abstract val left: Var
        abstract val right: Var
        abstract val operator: String
        override fun toGroovy(): String {
            return "${left.toGroovy()}.$operator(${right.toGroovy()})"
        }
        data class Contains(override val left: Var, override val right: Var) : StringOperator() {
            override val operator = "contains"
        }
        data class StartsWith(override val left: Var, override val right: Var) : StringOperator() {
            override val operator = "startsWith"
        }
        data class EndsWith(override val left: Var, override val right: Var) : StringOperator() {
            override val operator = "endsWith"
        }
    }
}
