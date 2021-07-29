package com.fbis.rickandmorty

import android.app.Application
import com.fbis.rickandmorty.di.AppComponent
import com.fbis.rickandmorty.di.DaggerAppComponent
import com.fbis.rickandmorty.di.NetworkModule

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .networkModule(NetworkModule())
            .build()
    }
}