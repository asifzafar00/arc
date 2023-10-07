package com.hathway.androidarc


class UserService(private val userRepository: UserRepository) {
    fun loginUser(email: String, password: String): String {
        val status = userRepository.loginUser(email = email, password = password)
        return when (status) {
            LOGIN_STATUS.INVALID_USER -> "User does not exist"
            LOGIN_STATUS.INVALID_PASSWORD -> "Password is invalid"
            LOGIN_STATUS.UNKNOWN_ERROR -> "Unknown error occrured"
            LOGIN_STATUS.SUCCESS -> "Logged in successfully"
        }
    }
}