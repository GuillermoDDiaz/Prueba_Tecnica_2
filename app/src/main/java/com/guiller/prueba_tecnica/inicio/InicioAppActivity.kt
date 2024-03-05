package com.guiller.prueba_tecnica.inicio

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.guiller.prueba_tecnica.adapter.datosAdapater
import com.guiller.prueba_tecnica.databinding.ActivityInicioAppBinding
import com.guiller.prueba_tecnica.datoApi.RetrofitClient
import com.guiller.prueba_tecnica.datoApi.dataApi
import com.guiller.prueba_tecnica.datoApi.dataApiItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class InicioAppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInicioAppBinding
    private  lateinit var adapter: datosAdapater
    private val cadenas = mutableListOf<dataApiItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_inicio_app)
        getRetrofit()
        initRecycle()


    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://mocki.io/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    private fun Petcion(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(RetrofitClient::class.java).datosGet("v1/eeced007-6b29-4c9d-ab63-c115a990d927")
            val response = call.body()
            runOnUiThread{

                if(call.isSuccessful) {
                    //val id = response?.id
                    //val name = response?.name
                    //val type = response?.type
                    //val ppu = response?.ppu
                    //val batters = response?.batters
                    //val topping = response?.topping ?: emptyList()

                    cadenas.clear()
                    cadenas.addAll(response)
                        cadenas = response


                }else{
                    Toast.makeText(this@InicioAppActivity, "No se devolvio nada", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    private fun initRecycle() {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.rw1.layoutManager =
            LinearLayoutManager(this) // vista de layout si quier diferente columas se agrega otro

        adapter = datosAdapater(cadenas)

        binding.rw1.adapter = datosAdapater(cadenas)


        binding.rw1.addItemDecoration(decoration)
    }
}