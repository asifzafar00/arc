package com.hathway.androidarc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var userRegistrationService: UserRegistrationService // Example of field Inject

    @Inject
    lateinit var emailService: EmailService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val components = DaggerUserRegistrationComponents.builder().build()
        components.inject(this)

          userRegistrationService.userRegistration("abc@gmail.com", "qwert@#123345")
         emailService.send(to = "ewe", from = "eeeeeee", body = "ddd")

        /*

         val emailService = components.getEmailService()
         emailService.send(to = "ewe", from = "eeeeeee", body = "ddd")
         val userRegistrationService = components.getUserRegistrationService()
         userRegistrationService.userRegistration("abc@gmail.com", "qwert@#123345")

         */
    }
}