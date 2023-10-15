package com.hathway.androidarc

import javax.inject.Inject

class UserRegistrationService @Inject constructor(
    private val userRepository: UserRepository,
    private val emailService: EmailService
) {
    fun userRegistration(email: String, password: String) {
        userRepository.saveUser(email, password)
        emailService.send(email, "no-replay@hathway.com", "This Dagger learning")
    }
}