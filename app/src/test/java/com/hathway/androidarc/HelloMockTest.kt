package com.hathway.androidarc

import com.hathway.androidarc.data.User
import com.hathway.androidarc.data.UserRepository
import com.hathway.androidarc.di.appModule
import org.junit.Rule
import org.junit.Test
import org.koin.core.logger.Level
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.mock.MockProviderRule
import org.koin.test.mock.declareMock
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.mockito.Mockito.times

class HelloMockTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger(Level.DEBUG)
        modules(appModule)
    }

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        Mockito.mock(clazz.java)
    }

    @Test
    fun `mock test`() {
        val service = declareMock<UserRepository> {
          //  given(getDefaultUser()).willReturn(User("MOCK"))
        }

       // MainActivity().sayHello()

       // Mockito.verify(service,times(1)).getDefaultUser()
    }
}