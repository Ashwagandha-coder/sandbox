package com.github.kotlinfeatures.multitreading

import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class EventCounter {
    private var count = 0

    private val lock = ReentrantLock()

    fun increment() = lock.withLock {
        count++
    }

    fun counter() = count
}