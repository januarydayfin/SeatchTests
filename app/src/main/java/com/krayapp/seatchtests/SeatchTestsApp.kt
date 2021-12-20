package com.krayapp.seatchtests

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SeatchTestsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SeatchTestsApp)
            modules(Koin.getModule())
        }
    }
}