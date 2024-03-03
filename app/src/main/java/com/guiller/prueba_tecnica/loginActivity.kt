package com.guiller.prueba_tecnica

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat

class loginActivity : AppCompatActivity() {



    private lateinit var txtUser: AppCompatEditText
    private lateinit var txtPass: AppCompatEditText
    private lateinit var btnReg: AppCompatButton
    private lateinit var btnIngres: AppCompatButton

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initcomponet()
        focusChanged()
        listenerComponet()

        }
    private fun initcomponet(){
        txtUser = findViewById(R.id.txtUser)
        txtPass = findViewById(R.id.txtPass)
        btnReg = findViewById(R.id.btnReg)
        btnIngres = findViewById(R.id.btnIngres)


    }
    private fun listenerComponet(){
        btnReg.setOnClickListener {
            if(checkNetwork(this)){
                val intent = Intent(this,registrActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "No se pudo conectar, verifique la conexion a internet", Toast.LENGTH_SHORT).show()
            }
        }
        btnIngres.setOnClickListener {
            if(validCamp()){

            }else
            {
                Toast.makeText(this, "Rellenar todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun focusChanged() {
        txtUser.setOnFocusChangeListener { V, hasFocus ->
            if (hasFocus) {
                txtUser.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_select))

            } else {
                txtUser.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt))
            }
        }
        txtPass.setOnFocusChangeListener { V, hasFocus ->
            if (hasFocus) {
                txtPass.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_select))

            } else {
                txtPass.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt))
            }
        }



    }
    private fun validCamp(): Boolean {

        val us =txtUser.text.toString()
        val pass = txtPass.text.toString()


        if(us.length < 1 && pass.length < 1 )
        {
            return caseCamp(3)
        }else if(us.length < 1 ){
            return caseCamp(1)

        }else if(pass.length < 1){
            return caseCamp(2)
        }else{
            return true
        }

    }
    private fun caseCamp(case: Int): Boolean{
        return when(case){
            0 ->{
                true
            }

            1 ->{ txtUser.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_error))
                false
            }

            2 -> {txtPass.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_error))
                false
            }
            3 -> {txtPass.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_error))
                txtUser.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_error))
                false
            }

            else -> false
        }
    }

    fun checkNetwork(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
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