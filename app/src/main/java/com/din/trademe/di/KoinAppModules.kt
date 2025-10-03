package com.din.trademe.di

import com.din.trademe.viewmodel.MainViewModel
import com.din.trademe.data.model.ListingRepository
import com.din.trademe.data.model.ListingRepositoryImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    // Injecting CoroutineDispatcher (Dispatchers.IO) for network operations.
    single<CoroutineDispatcher> { Dispatchers.IO }
    // Define how to create ListingRepositoryImpl and bind it to ListingRepository.
    singleOf(::ListingRepositoryImpl) bind ListingRepository::class
    // Injecting MainViewModel for the application.
    viewModel { MainViewModel(get()) }
}
