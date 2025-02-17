package com.github.kotlinfeatures.multitreading

import java.util.LinkedList
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class BoundedBuffer<T>(private val capacity: Int) {

    private val lock = ReentrantLock()
    private val notFull = lock.newCondition()
    private val notEmpty = lock.newCondition()
    private val buffer = LinkedList<T>()


    fun put(item: T) {
        lock.withLock {
            while (buffer.size == capacity) notFull.await()
            buffer.add(item)
            notEmpty.signal()
        }
    }

    fun take(): T {
        lock.withLock {
            while (buffer.isEmpty()) notEmpty.await()
            val item = buffer.remove()
            notFull.signal()
            return item
        }
    }


}