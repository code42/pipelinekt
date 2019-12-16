package com.code42.jenkins.pipelinekt.dsl

import java.util.Queue
import java.util.concurrent.LinkedBlockingQueue

open class DslContext<T>(val items: Queue<T> = LinkedBlockingQueue()) {

    companion object {
        fun <T> into(block: DslContext<T>.() -> Unit): List<T> {
            return DslContext<T>().into(block)
        }
    }

    fun add(item: T) {
        items.add(item)
    }

    fun drainAll(): List<T> {
        val result = items.toList()
        items.clear()
        return result
    }
}

fun <T, Dsl : DslContext<T>> Dsl.into(block: Dsl.() -> Unit): List<T> {
    this.block()
    return this.drainAll()
}

open class SingletonDslContext<T>(val items: Queue<T> = (LinkedBlockingQueue(1))) {
    companion object {
        fun <T> into(block: SingletonDslContext<T>.() -> Unit): T? {
            return SingletonDslContext<T>().into(block)
        }
    }

    fun add(item: T) {
        items.add(item)
    }

    fun drainAll(): List<T> {
        val result = items.toList()
        items.clear()
        return result
    }
}

fun <T, Dsl : SingletonDslContext<T>> Dsl.into(block: Dsl.() -> Unit): T? {
    this.block()
    return this.drainAll().firstOrNull()
}
