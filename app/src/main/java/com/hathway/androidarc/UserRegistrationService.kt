package com.hathway.androidarc

import javax.inject.Inject

class UserRegistrationService @Inject constructor(
    private val notificationService: NotificationService,
    private val userRepository: UserRepository
) {
    fun userRegistration(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "no-replay@hathway.com", "This Dagger learning")
    }
}