package com.guiller.prueba_tecnica.classes

import android.annotation.SuppressLint
import android.content.Context

class Pref(context: Context) {
    val SHAREDNAME= "MyData"
    val storage = context.getSharedPreferences(SHAREDNAME, 0)


    fun saveName(name:String){
        storage.edit().putString("name", name).apply()
    }

    fun saveUsernaame(username:String){
        storage.edit().putString("username", username).apply()
    }

    fun savePassword(password:String){
        storage.edit().putString("password", password).apply()
    }

    fun getName():String{
       return storage.getString("name","")!!
    }
    fun getUsername():String{
        return storage.getString("username","")!!
    }
    fun getPassword():String{
        return storage.getString("password","")!!
    }



}