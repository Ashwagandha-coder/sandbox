package com.github.kotlinfeatures

import java.util.logging.Logger

interface DataSource<out T> {
    fun getItems(): List<T>
}

// Concrete data classes
open class Animal(val name: String)
class Dog(name: String) : Animal(name)
class Cat(name: String) : Animal(name)

// Concrete data sourceimplementations
class AnimalDataSource(private val animals: List<Animal>) : DataSource<Animal> {
    override fun getItems(): List<Animal> = animals
}

class DogDataSource(private val dogs: List<Dog>) : DataSource<Dog> {
    override fun getItems(): List<Dog> = dogs
}

fun doing() {


    val dogs = listOf(Dog("Buddy"), Dog("Max"))
    val animals = listOf(Animal("Generic Animal"), Cat("Whiskers"))

    // Create data sources
    val dogDataSource: DataSource<Dog> = DogDataSource(dogs)
    val animalDataSource: DataSource<Animal> = AnimalDataSource(animals)

    // Covariance in action: We can treat a DataSource<Dog> as a DataSource<Animal>
    val anotherAnimalDataSource: DataSource<Animal> = dogDataSource

    // Use the data sources
    printItems(animalDataSource)
    printItems(anotherAnimalDataSource)


}

private fun printItems(dataSource: DataSource<Animal>) {
    val items = dataSource.getItems()
    for (item in items) {
        println("Logger - log")
    }
}
