package com.guiller.prueba_tecnica

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.lifecycleScope
import com.guiller.prueba_tecnica.classes.getUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class loginActivity : AppCompatActivity() {



    private lateinit var txtUser: AppCompatEditText
    private lateinit var txtPass: AppCompatEditText
    private lateinit var btnReg: AppCompatButton
    private lateinit var btnIngres: AppCompatButton
    private lateinit var hola: TextView

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
        hola = findViewById(R.id.hola)

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
                Login()
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


        return if(us.isEmpty() && pass.isEmpty() ) {
            caseCamp(3)
        }else if(us.isEmpty() ){
            caseCamp(1)

        }else if(pass.isEmpty()){
            caseCamp(2)
        }else{
            true
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
    private fun getusers() = dataStore.data.map {preferences ->
       getUser(name = preferences[stringPreferencesKey("name")].orEmpty(),
           username = preferences[stringPreferencesKey("username")].orEmpty(),
           password = preferences[stringPreferencesKey("password")].orEmpty() )
    }
    private fun Login()
    {
        lifecycleScope.launch(Dispatchers.IO){
            getusers().collect{
               withContext()
                hola.text = it.name
            }
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