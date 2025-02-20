package com.github.kotlinfeatures.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() {


    runBlocking {
        val windows = async(Dispatchers.IO) { order(Product.Windows) }
        val doors = async(Dispatchers.IO) { order(Product.Doors) }
        launch(Dispatchers.Default) {
            perform("laying bricks")
            launch { perform("installing ${windows.await().description}") }
            launch { perform("installing ${doors.await().description}") }
        }
    }

}


fun saveBaseCode() {
    runBlocking {
        launch {
            println("Hammer: Clothesline!")
            tagOut()
            println("Hammer: Piledriver!")
            tagOut()
            println("Ending")
        }
        println("Sledge: Suplex!")
        tagOut()
        println("Sledge: Figure-four Leglock!")
        tagOut()
        println("Sledge: Pinning 1-2-3!")


    }
}

suspend fun tagOut() {
    println("Tag Out")
    yield()

}

enum class Product(val description: String, val deliveryTime: Int) {
    Windows("windows", 32), Doors("doors", 56)
}

suspend fun order(item: Product): Product {
    println("ORDER EN ROUTE  >>> The ${item.description} are on the way!")
    delay(item.deliveryTime.toLong())
    println("ORDER DELIVERED >>> Your ${item.description} have arrived.")
    return item

}

suspend fun perform(taskName: String) {
    println("STARTING TASK   >>> $taskName")
    Thread.sleep(1_000)
    println("FINISHED TASK   >>> $taskName")
}
