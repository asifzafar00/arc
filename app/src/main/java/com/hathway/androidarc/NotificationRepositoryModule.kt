package com.hathway.androidarc

import dagger.Module
import dagger.Provides

@Module
class NotificationRepositoryModule {

    @Provides
    fun getEmailService():NotificationService{
        return EmailService()
    }
}