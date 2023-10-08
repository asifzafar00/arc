package com.hathway.androidarc.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.hathway.androidarc.repository.ProductRepository
import com.hathway.androidarc.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

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
    fun getProducts() = runTest {

        Mockito.`when`(repository.getProducts()).thenReturn(NetworkResult.Success(emptyList()))
        val obj=MainViewModel(repository)
        obj.getProduct()
        testDispatcher.scheduler.advanceUntilIdle()
        val result =obj.products.value!!
        Assert.assertEquals(0,result.data!!.size)
    }

    @Test
    fun getProduct() {
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}