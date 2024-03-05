package com.guiller.prueba_tecnica

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.guiller.prueba_tecnica.classes.registred.Companion.pref
import com.guiller.prueba_tecnica.databinding.ActivityLoginBinding
import com.guiller.prueba_tecnica.inicio.InicioAppActivity



class loginActivity : AppCompatActivity() {

private lateinit var binding: ActivityLoginBinding

    //private lateinit var txtUser: AppCompatEditText
    //private lateinit var txtPass: AppCompatEditText
    //private lateinit var btnReg: AppCompatButton
    //private lateinit var btnIngres: AppCompatButton



    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_login)

        //initcomponet()
        focusChanged()
        listenerComponet()


    }

    private fun initcomponet() {
        //txtUser = findViewById(R.id.txtUser)
        //txtPass = findViewById(R.id.txtPass)
        //btnReg = findViewById(R.id.btnReg)
        //btnIngres = findViewById(R.id.btnIngres)


    }

    private fun listenerComponet() {
        binding.btnReg.setOnClickListener {
            if (checkNetwork(this)) {
                val intent = Intent(this, registrActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    "No se pudo conectar, verifique la conexion a internet",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        binding.btnIngres.setOnClickListener {
            if (checkNetwork(this)) {
                if (validCamp()) {
                    if(Login()){
                        val intent = Intent(this, InicioAppActivity::class.java)
                        startActivity(intent)
                    }
                }else{

                    Toast.makeText(this, "Rellenar todos los campos", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "No se pudo conectar, porfavor verifique su conexion a internet", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun focusChanged() {
        binding.txtUser.setOnFocusChangeListener { V, hasFocus ->
            if (hasFocus) {
                binding.txtUser.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.border_txt_select
                    )
                )

            } else {
                binding.txtUser.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.border_txt
                    )
                )
            }
        }
        binding.txtPass.setOnFocusChangeListener { V, hasFocus ->
            if (hasFocus) {
                binding.txtPass.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.border_txt_select
                    )
                )

            } else {
                binding.txtPass.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.border_txt
                    )
                )
            }
        }


    }

    private fun validCamp(): Boolean {

        val us = binding.txtUser.text.toString()
        val pass = binding.txtPass.text.toString()


        return if (us.isEmpty() && pass.isEmpty()) {
            caseCamp(3)
        } else if (us.isEmpty()) {
            caseCamp(1)

        } else if (pass.isEmpty()) {
            caseCamp(2)
        } else {
            true
        }

    }

    private fun caseCamp(case: Int): Boolean {
        return when (case) {
            0 -> {
                true
            }

            1 -> {
                binding.txtUser.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.border_txt_error
                    )
                )
                false
            }

            2 -> {
                binding.txtPass.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.border_txt_error
                    )
                )
                false
            }

            3 -> {
                binding.txtPass.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.border_txt_error
                    )
                )
                binding.txtUser.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.border_txt_error
                    )
                )
                false
            }

            else -> false
        }
    }

    private fun Login(): Boolean {
        if (pref.getName().isNotEmpty()) {
            if (binding.txtUser.text.toString() == pref.getUsername()) {
                if (binding.txtPass.text.toString() == pref.getPassword()) {

                    Toast.makeText(this, "El usuario es correcto", Toast.LENGTH_SHORT).show()
                    return true
                } else {
                    Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                    return false
                }
            } else {
                Toast.makeText(this,  "Usuario incorrecto", Toast.LENGTH_SHORT).show()
                return false
            }
        }else{
             return false
        }
    }

    private fun checkNetwork(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
        return false
    }


}