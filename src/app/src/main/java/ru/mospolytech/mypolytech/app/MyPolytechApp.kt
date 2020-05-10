package ru.mospolytech.mypolytech.app

import android.app.Application

class MyPolytechApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ComponentInitializer(this).initAppComponent()
    }
}