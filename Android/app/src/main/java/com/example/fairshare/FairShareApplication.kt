package com.example.fairshare

import android.app.Application
import org.koin.android.ext.android.startKoin

class FairShareApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(KoinModule.getModule(this)))
    }
}