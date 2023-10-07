package com.hathway.androidarc

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


internal class UserServiceTest {
    @Mock
    lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(userRepository.loginUser(anyString(), anyString()))
            .thenReturn(LOGIN_STATUS.INVALID_PASSWORD)


    }

    @Test
    fun loginUserTest() {
        Mockito.`when`(userRepository.loginUser(anyString(), anyString()))
            .thenReturn(LOGIN_STATUS.INVALID_PASSWORD)
        val userSlut = UserService(userRepository = userRepository)
        val status = userSlut.loginUser("anb@yahoo.com", "1212122")
        Assert.assertEquals("Password is invalid", status)

        Mockito.`when`(userRepository.loginUser(anyString(), anyString()))
            .thenReturn(LOGIN_STATUS.SUCCESS)
        val u = UserService(userRepository = userRepository)
        val s = u.loginUser("anb@yahoo.com", "1212122")
        Assert.assertEquals("Logged in successfully", s)
    }


}