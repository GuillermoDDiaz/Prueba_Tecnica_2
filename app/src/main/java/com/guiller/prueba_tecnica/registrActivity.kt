package com.guiller.prueba_tecnica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class registrActivity : AppCompatActivity() {


    private lateinit var btnCancel: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registr)
        initComponet()
        initListeners()
    }
    private fun initComponet(){
        btnCancel = findViewById(R.id.btnCancel)
    }
    private fun initListeners(){
        btnCancel.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }
}