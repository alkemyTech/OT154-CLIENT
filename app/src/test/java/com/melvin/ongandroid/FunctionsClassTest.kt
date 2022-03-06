package com.melvin.ongandroid

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class FunctionsClassTest : TestCase(){

    @MockK
    lateinit var validationFunctions: ValidationFunctions

    lateinit var functionsClass: FunctionsClass
    @Before
    override fun setUp() {
        super.setUp()
        MockKAnnotations.init(this)
        functionsClass = FunctionsClass(validationFunctions)
    }


    @Test
    fun testSumaWhenvalidateiSTreuReturnValue(){
        val a = 2
        val b = 2
        every { validationFunctions.isValidated() } answers { true }

        val result = functionsClass.suma(a, b)

        Assert.assertEquals(4, result)
    }

    @Test
    fun testSumaWhenValidationIsFalseReturnValue(){
        val a = 2
        val b = 2
        every { validationFunctions.isValidated() } answers { false }

        val result = functionsClass.suma(a, b)

        Assert.assertEquals(3, result)
    }
}