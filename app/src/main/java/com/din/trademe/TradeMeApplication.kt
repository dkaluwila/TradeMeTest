package com.din.trademe

import android.app.Application
import com.din.trademe.di.appModule
import com.din.trademe.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class TradeMeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@TradeMeApplication)
            // Declare modules to load
            modules(appModule, networkModule)
        }
    }
}
