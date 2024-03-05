package com.guiller.prueba_tecnica.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface retrofit {

    @GET("v1/eeced007-6b29-4c9d-ab63-c115a990d927")
    suspend fun datosGet():RespnseApi




}