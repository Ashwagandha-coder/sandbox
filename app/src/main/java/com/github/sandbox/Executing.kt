package com.github.sandbox




fun main() {

    sampleTime()

}

fun sampleTime() {
    val time = measureTimeMillis {
        concatString("Array")
    }
}

private fun concatString(string: String): String {
    var temp = ""
    repeat(10000) {
        temp += string + it
    }
    println(temp)
    return temp
}

fun sampleLog() {
    log { "Logger My App" }
}









