package com.github.sandbox

fun main() {
    val pass = Password("5435345345345")

}


@JvmInline
value class Password(val password: String)