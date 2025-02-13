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

fun testingTailRec() {
    factorial(5).also { println(it) }
}

private tailrec fun factorial(n: Int): Int {
    return when {
        n == 1 -> 1
        else -> n * factorial(n - 1)
    }
}


class Box<T>(type: T) {

    private val structure = mutableListOf<T>()

    fun pack(element: T): Boolean = structure.add(element)

    fun unpack(): T = structure.last()

}


fun usingBox() {

    val box = Box(1)
    box.pack(45)
    box.pack(50)
    println(box.unpack())

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


