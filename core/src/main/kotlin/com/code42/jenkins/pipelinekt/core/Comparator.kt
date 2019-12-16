package com.code42.jenkins.pipelinekt.core

sealed class Comparator {
    abstract fun toGroovy(): String
    object Equals : Comparator() {
        override fun toGroovy(): String = "'EQUALS'"
    }
    object Regexp : Comparator() {
        override fun toGroovy(): String = "'REGEXP'"
    }
    object Glob : Comparator() {
        override fun toGroovy(): String = "'GLOB'"
    }
}
