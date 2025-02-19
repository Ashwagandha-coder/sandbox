package com.github.sandbox

import kotlinx.coroutines.delay

class MyRepository {

    suspend fun fetchData(): String {
        delay(100)
        return "Expected Data"
    }
}