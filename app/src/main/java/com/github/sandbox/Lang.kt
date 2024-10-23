package com.github.sandbox

@JvmInline
value class Email(val value: String) {
    init {
        require(value.contains("@")) { "Invalid email format" }
    }
}