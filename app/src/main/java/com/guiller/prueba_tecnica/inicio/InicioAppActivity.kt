package com.guiller.prueba_tecnica.inicio

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
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


class InicioAppActivity() : AppCompatActivity(), passDetalel {

    companion object {
        private lateinit var topping: List<Topping>
        private lateinit var batters: List<Batter>
        private lateinit var respon: RespnseApi
        fun getResponse(): RespnseApi = respon
        fun getBattter(): List<Batter> = batters
        fun getTopping(): List<Topping> = topping
    }

    private lateinit var binding: ActivityInicioAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.activity_inicio_app)
        val nombre=
        Peticion()
        saludar("Juancho")
        pressBack()

    }

    private fun saludar(usuario: String) {
        val builder = AlertDialog.Builder(this@InicioAppActivity)
        builder.setTitle("Bienvenido")
        builder.setMessage("Hola $usuario")
        builder.setPositiveButton(android.R.string.ok) { dialog, which ->
        }
        builder.show()
    }

    private fun pressBack() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val builder = AlertDialog.Builder(this@InicioAppActivity)
                builder.setTitle("Salir")
                builder.setMessage("Esta seguro que desea salir")
                builder.setPositiveButton(android.R.string.ok) { dialog, which ->
                    finish()
                }
                builder.setNegativeButton("Cancelar", null)
                builder.show()


            }
        })

    }

    private fun getRetrofit(): retrofit {
        return Retrofit.Builder()
            .baseUrl("https://mocki.io/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(retrofit::class.java)
    }

    private fun Peticion() {
        CoroutineScope(Dispatchers.IO).launch {
            val service = getRetrofit().datosGet()
            runOnUiThread {
                respon = service
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    add<MaestroFragment>(R.id.FragMaest)
                }

            }
        }

    }


    override fun datoDetalle(data: List<Topping>, dataB: List<Batter>) {

        topping = data
        batters = dataB
        supportFragmentManager.beginTransaction().replace(R.id.FragDetalle, DetalleFragment())
            .commit()


    }
}