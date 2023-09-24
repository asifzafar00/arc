package com.hathway.androidarc

import org.junit.Test


internal class AppTestViewModelTest{
    private val viewModel = AppTestViewModel()


    @Test
    fun addTwoNumber_test_two_number()  {
        var currentGameUiState = viewModel.addTwoNumber(2,3)

    }
}