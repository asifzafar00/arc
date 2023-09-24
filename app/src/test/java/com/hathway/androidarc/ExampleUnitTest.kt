package com.hathway.androidarc

import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
       // val actual = addTwoNum(2, 2)
        val calculator = mock(Myca::class.java)
        // Define the behavior of the mock function
        `when`(calculator.addTwoNum(5, 3)).thenReturn(49)

        // Call the mock function
        val result = calculator.addTwoNum(5, 3)
        assertEquals(49, result)
    }
}