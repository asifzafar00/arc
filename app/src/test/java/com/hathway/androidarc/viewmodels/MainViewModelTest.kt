package com.hathway.androidarc.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.hathway.androidarc.getOrAwaitValue
import com.hathway.androidarc.repository.ProductRepository
import com.hathway.androidarc.utils.NetworkResult
import com.hathway.androidarc.viewmodels.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: ProductRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun getProducts_list_empty() = runTest {

        Mockito.`when`(repository.getProducts()).thenReturn(NetworkResult.Success(emptyList()))
        val obj = MainViewModel(repository)
        obj.getProduct()
        testDispatcher.scheduler.advanceUntilIdle()
        val result = obj.products.getOrAwaitValue { }
        Assert.assertEquals(0, result.data!!.size)
    }

    @Test
    fun getProducts_error_return() = runTest {

        Mockito.`when`(repository.getProducts())
            .thenReturn(NetworkResult.Error("Something went wrong"))
        val obj = MainViewModel(repository)
        obj.getProduct()
        testDispatcher.scheduler.advanceUntilIdle()
        val result = obj.products.getOrAwaitValue { }
        Assert.assertEquals(true, result is NetworkResult.Error)
        Assert.assertEquals("Something went wrong", result.massage)
    }



    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}