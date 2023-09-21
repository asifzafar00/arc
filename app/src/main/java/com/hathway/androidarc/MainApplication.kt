package com.hathway.androidarc

import android.app.Application
import com.hathway.androidarc.data.DefaultData.DEFAULT_USERS
import com.hathway.androidarc.data.UserRepository
import com.hathway.androidarc.di.appModule
import com.hathway.androidarc.di.appModule2
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {

    private val userRepository: UserRepository by inject()

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            androidLogger()
            // modules(appModule)
            modules(appModule2)
        }

        userRepository.addUsers(DEFAULT_USERS)
    }

}