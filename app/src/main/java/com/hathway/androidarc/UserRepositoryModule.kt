package com.hathway.androidarc

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class UserRepositoryModule {

   /* @Provides
    fun getFireBaseUserRepository(fireBaseUserRepository: FireBaseUserRepository): UserRepository {
        return FireBaseUserRepository()
    }*/

    @Binds
    abstract fun getSQlUserRepository(sQlUserRepository: SQlUserRepository): UserRepository
}