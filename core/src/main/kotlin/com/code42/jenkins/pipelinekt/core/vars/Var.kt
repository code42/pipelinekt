package com.code42.jenkins.pipelinekt.core.vars

import com.code42.jenkins.pipelinekt.core.step.Step
import com.code42.jenkins.pipelinekt.core.writer.GroovyWriter
import com.code42.jenkins.pipelinekt.core.writer.ext.allButLast
import java.io.PrintWriter
import java.io.StringWriter

/**
 * Represents a var that is written to groovy
 */
sealed class Var {
    abstract fun toGroovy(): String
    fun interpolated(): String = "\${${this.toGroovy()}}"
    final override fun toString(): String = interpolated()

    object Null : Var() {
        override fun toGroovy(): String {
            return "null"
        }
    }
    data class ClosureInvocation(val name: String, val arguments: List<Var> = emptyList()) : Var() {
        override fun toGroovy(): String =
                "$name(${arguments.map { it.toGroovy()}.allButLast { "$it, "}.joinToString("")})"
    }

    /**
     * Access an environment variable from groovy
     * @param name the name of the environmentVar variable to use in a groovy script
     */
    data class Environment(val name: String) : Var() {
        override fun toGroovy(): String {
            return "env.$name"
        }
    }

    /**
     * Access literal vars in groovy
     */
    sealed class Literal : Var() {

        data class Inline(val text: String) : Literal() {
            override fun toGroovy(): String {
                return text
            }
        }
        sealed class Str : Literal() {
            abstract val value: String

            /**
             * Single quoted groovy string
             *
             * @param value written out as a single quoted string
             */
            data class Single(override val value: String) : Str() {
                override fun toGroovy(): String {
                    return "'$value'"
                }
            }

            /**
             * Double quoted groovy string
             *
             * @param value written out as a double quoted string
             */
            data class Double(override val value: String) : Str() {
                override fun toGroovy(): String {
                    return "\"$value\""
                }
            }

            data class Multiline(override val value: String) : Str() {
                override fun toGroovy(): String {
                    return "\"\"\"$value\"\"\""
                }
            }
        }
        data class Int(val value: kotlin.Int) : Literal() {
            override fun toGroovy(): String {
                return "$value"
            }
        }

        /**
         * Literal boolean in groovy
         *
         * @param value the boolean variable to be written as a boolean value
         */
        data class Bool(val value: Boolean) : Literal() {
            override fun toGroovy(): String {
                return value.toString()
            }
        }

        data class Closure(val steps: Step) : Literal() {
            override fun toGroovy(): String {
                if (steps.isEmpty()) {
                    return "{ }"
                }
                val out = StringWriter()
                val writer = GroovyWriter(PrintWriter(out), 0, indentStr = "  ")
                writer.writeln("{")
                steps.toGroovy(writer.inner())

                return out.toString() + "}"
            }
        }
    }

    data class Variable(val name: String) : Var() {
        override fun toGroovy(): String {
            return name
        }

        fun accessMember(memberName: String): Variable {
            return this.copy(name = "$name.$memberName")
        }
    }

    data class Field(val name: String) : Var() {
        override fun toGroovy(): String {
            return name
        }
    }
    abstract class External : Var()
}
