package com.din.trademe.di

import com.din.trademe.data.network.TradeMeApiService
import com.din.trademe.data.network.TradeMeAuthInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    val baseUrl = "https://api.tmsandbox.co.nz/"

    // AuthInterceptor for authentication
    single { TradeMeAuthInterceptor() }

    // Update OkHttpClient to use the AuthInterceptor
    single {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(get<TradeMeAuthInterceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(TradeMeApiService::class.java)
    }
}
