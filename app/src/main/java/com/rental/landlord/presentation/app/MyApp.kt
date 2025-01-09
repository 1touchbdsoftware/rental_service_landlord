package com.rental.landlord.presentation.app

import android.app.Application
import com.rental.landlord.di.dataStoreModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        startKoin {
            androidContext(this@MyApp)
            modules(
                modules = listOf(dataStoreModule)
            )
        }
        super.onCreate()
    }
}