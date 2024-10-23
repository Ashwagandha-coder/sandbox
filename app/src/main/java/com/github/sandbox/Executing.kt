package com.github.sandbox


fun main() {

    val list = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)


    list.map { it * 2 }.let {
        print("$it ")
    }

}







