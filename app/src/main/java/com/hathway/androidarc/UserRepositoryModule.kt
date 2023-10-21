package com.hathway.androidarc

import dagger.Binds
import dagger.Module

@Module
abstract class UserRepositoryModule {
    @Binds
    abstract fun getSQlUserRepository(sQlUserRepository: SQlUserRepository): UserRepository
}