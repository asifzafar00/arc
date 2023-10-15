package com.hathway.androidarc

import android.app.Application
import dagger.Component

@Component
interface UserRegistrationComponents {
    fun getUserRegistrationService():UserRegistrationService

}

// appComponent lives in the Application class to share its lifecycle
class MyApplication: Application() {
    // Reference to the application graph that is used across the whole app
    val appComponent = DaggerUserRegistrationComponents.create()
}

