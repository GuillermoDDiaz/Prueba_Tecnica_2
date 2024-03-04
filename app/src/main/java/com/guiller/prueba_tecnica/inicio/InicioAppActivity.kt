package com.guiller.prueba_tecnica.inicio

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.guiller.prueba_tecnica.R
import com.guiller.prueba_tecnica.adapter.datosAdapater
import com.guiller.prueba_tecnica.classes.Proveedor
import com.guiller.prueba_tecnica.databinding.ActivityInicioAppBinding


class InicioAppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInicioAppBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_inicio_app)
        initRecycle()


    }
    private fun initRecycle(){
        binding.rw1.layoutManager = LinearLayoutManager(this) // vista de layout si quier diferente columas se agrega otro
        binding.rw1.adapter = datosAdapater(Proveedor.DatosList)
    }
}