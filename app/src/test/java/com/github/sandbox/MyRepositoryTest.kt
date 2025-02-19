package com.github.sandbox

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class MyRepositoryTest {


    @Test
    fun `fetch_data`() = runBlocking {
        val repository = MyRepository()
        val data = repository.fetchData()
        assertEquals("Expected Data", data)
    }

}