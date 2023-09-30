package com.hathway.androidarc

class ValidatePassword {


    /// Problem statement : validate password
    // Should not be empty
    // length should between 6 & 15
    // otherwise, return Valid password
    fun validatePassword(a: String): Boolean {
        println("length:" + a.length)
        if (a.isNotBlank() && a.isNotEmpty() && a.length in 6..15)
            return true

        return false
    }


    // Problem Statement : String Reversal
    fun stringReversal(a: String?): String {
        if (a == null){
            throw IllegalAccessException("Input String is Required")
        }
        var b = ""
        if (a.isNotBlank() && a.length > 1) {
            for (i in a.length - 1 downTo 0)
                b += a[i]

            return b
        }


        return a
    }
}