package com.github.kotlinfeatures.coroutine

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Test

fun main() {


    runBlocking {
        println("Sledge: Suplex!")
        println("Hammer: Clothesline!")
        runBlocking {
            println("Sledge: Figure-four Leglock!")
            println("Hammer: Piledriver!")
        }
        println("Sledge: Pinning 1-2-3!")
    }


}

class MyRepositoryTest {

    @Test
    fun `fetch_data`() = runBlocking {

        val repository = MyRepository()

        val data = repository.fetchData()

        assertEquals("Expected data", data)

    }
}

class MyRepository {

    suspend fun fetchData(): String {
        delay(100)
        return "Expected Data"
    }
}