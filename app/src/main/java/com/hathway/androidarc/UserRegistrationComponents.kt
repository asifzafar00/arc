package com.hathway.androidarc

import android.app.Application
import dagger.Component

@Component(
    modules = [UserRepositoryModule::class, NotificationRepositoryModule::class
    ]
)
interface UserRegistrationComponents {
    /*   fun getUserRegistrationService():UserRegistrationService
       fun getEmailService():EmailService*/
    fun inject(mainActivity: MainActivity)

}

// appComponent lives in the Application class to share its lifecycle
class MyApplication: Application() {
    // Reference to the application graph that is used across the whole app
    //val appComponent = DaggerUserRegistrationComponents.create()
}

