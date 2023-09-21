package com.hathway.androidarc.di

import android.system.Os.bind
import com.hathway.androidarc.UserPresenter
import com.hathway.androidarc.UserViewModel
import com.hathway.androidarc.data.UserRepository
import com.hathway.androidarc.data.UserRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module



val appModule2 = module {

    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
    factoryOf(::UserPresenter)
    viewModelOf(::UserViewModel)
}

 //Classical DSL version
val appModule = module {
    single<UserRepository> { UserRepositoryImpl() }
    factory { UserPresenter(get()) }
    viewModel { UserViewModel(get()) }
}