package com.github.kotlinfeatures

fun something(string: String): Boolean {
    return string.isEmpty()
}

fun testingMultiple() {

    val a = 5
    val b = 3
    println(a multiple b)
    println(a substraction b)
    println(a divide b)
    println(a sum b)

}

infix fun Int.substraction(number: Int): Int = this - number


infix fun Int.divide(number: Int): Int {
    return this / number
}

infix fun Int.sum(number: Int): Int {
    return this + number
}

infix fun Int.multiple(number: Int): Int {
    return this * number
}
