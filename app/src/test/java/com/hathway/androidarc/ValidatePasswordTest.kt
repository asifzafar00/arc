package com.hathway.androidarc

import org.junit.Assert
import org.junit.Before
import org.junit.Test


internal class ValidatePasswordTest {

    lateinit var objClass: ValidatePassword

    @Before
    fun setUp() {
        objClass = ValidatePassword()
    }

    /// Problem statement : validate password
    // Should not be empty
    // length should between 6 & 15
    // otherwise, return Valid password
    @Test
    fun validatePasswordTest() {
        // blank string
        Assert.assertEquals(false, objClass.validatePassword("     "))

        // empty string
        Assert.assertEquals(false, objClass.validatePassword(""))

        // length should below 6
        Assert.assertEquals(false, objClass.validatePassword("asasa"))

        // length should above 15
        Assert.assertEquals(false, objClass.validatePassword("asawsaswaswasdwsds"))

        // valid string  of length 6
        Assert.assertEquals(true, objClass.validatePassword("asdfgh"))
        // valid string  of length 15

        Assert.assertEquals(true, objClass.validatePassword("asdfghjkljhgfdr"))


    }

    // Problem Statement : String Reversal
    @Test
    fun stringReversalTest() {

        //string is blank
        Assert.assertEquals("", objClass.stringReversal(""))

        // string length is 1
        Assert.assertEquals("a", objClass.stringReversal("a"))

        // string length is greater then 1
        Assert.assertEquals("ba", objClass.stringReversal("ab"))
        // string length is greater then 2
        Assert.assertEquals("abc", objClass.stringReversal("cba"))

        // string length is greater then 2
        Assert.assertEquals("asdfghjklA", objClass.stringReversal("Alkjhgfdsa"))

    }
}