package com.towerowl.spotifytest

import android.app.Application
import com.towerowl.spotifytest.dagger.DaggerAppComponent

class App : Application() {

    val appComponent by lazy {
        DaggerAppComponent.builder()
            .build()
    }

    companion object {
        @Volatile
        private var instance: App? = null

        fun getInstance(): App {
            return instance ?: synchronized(this) {
                instance ?: App().also { instance = it }
            }
        }
    }

}