package com.github.sandbox


/**
 * Example of use value class
 */


@JvmInline
value class Email(val value: String) {
    init {
        require(value.contains("@")) { "Invalid email format" }
    }
}

data class Dimensions(val width: Int, val height: Int)

@JvmInline
value class ScreenDimensions(val dimen: Dimensions)

@JvmInline
value class Percentage(val value: Int) {
    init {
        require(value in 0..100) {
            "Percentage value must be between 0 and 100"
        }
    }

}