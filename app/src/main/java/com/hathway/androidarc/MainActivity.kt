package com.hathway.androidarc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val userRegistrationService =
            DaggerUserRegistrationComponents.builder().build().getUserRegistrationService()
        userRegistrationService.userRegistration("abc@gmail.com", "qwert@#123345")
    }
}