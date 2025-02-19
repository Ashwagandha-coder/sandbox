package com.github.kotlinfeatures.generics


class Coin

class Snack

interface VendorMachine<in T, out R> {

    fun purchase(money: T): R

}

class SnackMachine() : VendorMachine<Coin, Snack> {
    override fun purchase(money: Coin): Snack = Snack()
}

class StickMachine(): VendorMachine<Coin, Snack> {
    override fun purchase(money: Coin): Snack {
        TODO("Not yet implemented")
    }
}