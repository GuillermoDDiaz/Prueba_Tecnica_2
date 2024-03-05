package com.guiller.prueba_tecnica.inicio

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.guiller.prueba_tecnica.R
import com.guiller.prueba_tecnica.adapter.datosAdapater
import com.guiller.prueba_tecnica.api.RespnseApi
import com.guiller.prueba_tecnica.api.RespnseApiItem
import com.guiller.prueba_tecnica.api.retrofit
import com.guiller.prueba_tecnica.databinding.ActivityInicioAppBinding
import com.guiller.prueba_tecnica.fragmets.MaestroFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.jar.Attributes.Name


class InicioAppActivity : AppCompatActivity() {

companion object{
    private var cad: RespnseApi? = null
    fun Getcadena(): RespnseApi? {
        return cad
    }
}

    private lateinit var binding: ActivityInicioAppBinding
    private lateinit var adapter: datosAdapater


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_inicio_app)
        Peticion()




    }



    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://mocki.io/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    private fun Peticion() {
        CoroutineScope(Dispatchers.IO).launch {
            val service = getRetrofit().create(retrofit::class.java).datosGet()
            runOnUiThread {
                cad = service
                val bundle = bundleOf(

                )
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    add<MaestroFragment>(R.id.FragMaest, args = bundle)
            }

        }
    }
    }
  //  private fun initRecycle(cadenas: RespnseApi) {
//
  //      binding.rw1.layoutManager =
  //          LinearLayoutManager(this) // vista de layout si quier diferente columas se agrega otro
  //      //adapter = datosAdapater(cadenas)
  //      binding.rw1.adapter = datosAdapater(cadenas) { Seleccionado(it) }
  //  }

   // private fun initRecycle(cadenas: RespnseApi) {
//
   //     binding.rw1.layoutManager =
   //         LinearLayoutManager(this) // vista de layout si quier diferente columas se agrega otro
   //     //adapter = datosAdapater(cadenas)
   //     binding.rw1.adapter = datosAdapater(cadenas){Seleccionado(it)}
//
//
   // }
   // fun Seleccionado(datos:RespnseApiItem) {
   // Toast.makeText(this, datos.id, Toast.LENGTH_SHORT).show()
   // //binding.rw1.visibility = View.INVISIBLE
   // val bundle = bundleOf(
   //     "param1" to datos.id.toString(),
   //     "param2" to datos.type.toString(),
   //     "param3" to datos.ppu.toString(),
   //     "param4" to datos.name
   //
   // )
   // supportFragmentManager.commit {
   //     setReorderingAllowed(true)
   //     add<MaestroFragment>(R.id.FragMaest, args = bundle)
   // }

   //

}