package com.guiller.prueba_tecnica.classes

import android.app.Application

class registred:Application() {
companion object{
    lateinit var pref: Pref
}

    override fun onCreate() {
        super.onCreate()
        pref = Pref(applicationContext)
    }
}