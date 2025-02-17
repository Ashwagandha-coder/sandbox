package com.github.sandbox

import android.app.Activity
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.locks.Condition


fun main() {

    dodododododo()


}



fun dodododododo() {

    val map = ConcurrentHashMap<Int, Int>()


    //ConcurrentHashMap
    var myMap: MutableMap<String, String?> = ConcurrentHashMap()
    myMap["1"] = "1"
    myMap["2"] = "1"
    myMap["3"] = "1"
    myMap["4"] = "1"
    myMap["5"] = "1"
    myMap["6"] = "1"
    myMap.put("10", "debug")
    println("ConcurrentHashMap before iterator: $myMap")
    val it: Iterator<String> = myMap.keys.iterator()

    while (it.hasNext()) {
        val key = it.next()
        if (key == "3") myMap[key + "new"] = "new3"
    }
    println("ConcurrentHashMap after iterator: $myMap")


    //HashMap
    myMap = HashMap()
    myMap["1"] = "1"
    myMap["2"] = "1"
    myMap["3"] = "1"
    myMap["4"] = "1"
    myMap["5"] = "1"
    myMap["6"] = "1"
    println("HashMap before iterator: $myMap")
    val it1: Iterator<String> = myMap.keys.iterator()

    while (it1.hasNext()) {
        val key = it1.next()
        if (key == "3") myMap[key + "new"] = "new3"
    }
    println("HashMap after iterator: $myMap")


}

fun make() {

    val activity = Activity()

    val map = ConcurrentHashMap<Int, Int>()

}