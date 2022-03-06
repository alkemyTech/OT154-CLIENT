package com.melvin.ongandroid

class FunctionsClass(private val validation : ValidationFunctions) {

    fun suma(a: Int, b: Int): Int {
        return if (validation.isValidated())
            a + b
        else
            (a + b) - 1
    }
}