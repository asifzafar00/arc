package com.hathway.androidarc

class Myca {


    fun addTwoNum(a: Int = 10, b: Int = 20): Int {
        return a + b;
    }


    fun isPallindrome(inputStr: String): Boolean {
        var i = 0
        var j = inputStr.length - 1
        var result = true
        while (i < j) {
            if (inputStr[i] != inputStr[j]) {
                result = false
            }
            i++
            j--
        }

        return result

    }
}