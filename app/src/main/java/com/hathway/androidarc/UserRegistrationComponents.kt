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

class MyApplication : Application()

