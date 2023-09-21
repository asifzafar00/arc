package com.hathway.androidarc


import com.hathway.androidarc.di.appModule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject

class HelloAppTest : KoinTest {

   // val service by inject<UserService>()

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger()
        modules(appModule)
    }

    @Test
    fun `unit test`() {
        val helloApp = MainApplication()
       // helloApp.sayHello()

        //assertEquals(service, helloApp.userService)
    }
}