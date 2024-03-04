package com.guiller.prueba_tecnica.inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.guiller.prueba_tecnica.R
import com.guiller.prueba_tecnica.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_inicio_app.btns


class inicioAppActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        //setContentView(R.layout.activity_inicio_app)
    }
}