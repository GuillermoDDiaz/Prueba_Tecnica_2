package com.guiller.prueba_tecnica.datoApi

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

interface RetrofitClient {
    @GET
    fun datosGet(@Url url: String):Response<dataApiItem>
    //fun datosGet(@Url url: String):Response<dataApiItem>

}