package com.github.kotlinfeatures.multitreading


import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.thread
import kotlin.concurrent.withLock




fun lockUsing() {

    val counter = Counter()

    val thread1 = thread(name = "Thread - 1") {

        for (i in 0..10) counter.increment()

        println("Thread - 1 was finished")

    }

    val thread2 = thread(name = "Thread - 2") {

        for (i in 0..10) counter.decrement()


        println("Thread - 2 was finished")

    }

    thread1.join()
    thread2.join()

    println("${counter.count} - Counter")


}

class Counter {

    private val lock = ReentrantLock()
    var count = 0
        private set


    fun increment() = lock.withLock {
        count++
        println("${Thread.currentThread().name} - $count")
    }


    fun decrement() = lock.withLock {
        count--
        println("${Thread.currentThread().name} - $count")
    }


}


