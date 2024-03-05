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
import com.guiller.prueba_tecnica.api.Batter
import com.guiller.prueba_tecnica.api.RespnseApi
import com.guiller.prueba_tecnica.api.RespnseApiItem
import com.guiller.prueba_tecnica.api.Topping
import com.guiller.prueba_tecnica.api.retrofit
import com.guiller.prueba_tecnica.databinding.ActivityInicioAppBinding
import com.guiller.prueba_tecnica.fragmets.DetalleFragment
import com.guiller.prueba_tecnica.fragmets.MaestroFragment
import com.guiller.prueba_tecnica.interfac.passDetalel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.jar.Attributes.Name


class InicioAppActivity : AppCompatActivity(), passDetalel{

companion object{
    private var cad: RespnseApi? = null
    private var topp: List<Topping>? = null
    private var batter: List<Batter>? = null
    fun Getcadena(): RespnseApi? {
        return cad
    }
    fun GetTopp(): List<Topping>? {
        return topp
    }
    fun GetBatter(): List<Batter>? {
        return batter
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



    override fun datoDetalle(data: List<Topping>,dataB:List<Batter>) {
        topp = null
        topp = data
        batter = null
         batter = dataB
        supportFragmentManager.beginTransaction().replace(R.id.FragDetalle,DetalleFragment()).commit()


}
}