package com.hathway.androidarc

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
import java.util.concurrent.atomic.AtomicBoolean


internal class UtilsTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setup() {
    }

    @Test
    fun getUsers() {
        val sut = Utils(mainCoroutineRule.testDispatcher)
        runTest {
            sut.getUserName()
        }
    }

    @Test
    fun getUsersMainDispatcher() {
        val sut = Utils(mainCoroutineRule.testDispatcher)
        runTest {
            sut.getUser()
        }
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getAddressTest() {
        val sut = Utils(mainCoroutineRule.testDispatcher)
        runTest {
            sut.getAddress()
        }
    }
    val initialized = AtomicBoolean(false)


    @Test
    fun getNameTest() {
        val sut = Utils(mainCoroutineRule.testDispatcher)
        runTest {
            sut.getName()
            mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
            Assert.assertEquals(true, sut.globalArg)
        }
    }
}