package com.hathway.androidarc

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class isPallindromeT {
    lateinit var helper:Myca
    @Before
    fun setUP(){
         helper=Myca()
    }

    @Test
    fun testisPallindromeFalseHhelle(){


       var result= helper.isPallindrome("hello")
        assertEquals(false,result)
    }
}