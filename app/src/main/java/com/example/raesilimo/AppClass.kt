package com.example.raesilimo

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppClass : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: AppClass? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }
}