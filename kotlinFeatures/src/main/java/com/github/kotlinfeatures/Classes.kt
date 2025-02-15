package com.github.kotlinfeatures

class Work {

    private val fuck = "Fuck"

    private val products = listOf(
        Product("Coffee", 22, "Drinks"),
        Product("Tea", 45, "Drinks"),
        Product("Laptop", 500, "Electronic")
    )

    fun doSome() = "Working"


    inner class Job {

        fun fucking() {
            println(fuck.length)
            doSome()
        }

    }


    inner class ProductProcessor {

        fun filterByCategory(category: String): List<Product> {
            return products.filter { it.category == category }
        }

        fun calculateAveragePrice(): Double {
            return when {
                products.isEmpty() -> 0.0
                else -> products.sumOf { it.price } / products.size.toDouble()
            }
        }

        fun fuckingPrintln() {
            val productProcessor = ProductProcessor()
            val drinks = productProcessor.filterByCategory("Drinks")
            val electronics = productProcessor.filterByCategory("Electronic")
            drinks.forEach { println(it) }
            electronics.forEach { println(it) }
        }


    }

    data class Product(val name: String, val price: Int, val category: String)

}


enum class DayOfWeek {

    Monday, Tuesday, Wensday, Thusday, Friday, Saturday, Sunday,

}

enum class Color(val label: String) {
    Blue("blue"), Red("red"), Green("green")
}


fun fucking() {
    val color = Color.entries
}


