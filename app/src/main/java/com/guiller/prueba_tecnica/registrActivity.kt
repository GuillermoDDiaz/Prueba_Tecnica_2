package com.guiller.prueba_tecnica

import android.content.Context
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

class registrActivity : AppCompatActivity() {



    private lateinit var btnCancel: AppCompatButton
    private lateinit var btnRegist: AppCompatButton
    private lateinit var txtUserName: AppCompatEditText
    private lateinit var txtUser2: AppCompatEditText
    private lateinit var txtPass2:AppCompatEditText
    private lateinit var  txtPassVerif:AppCompatEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registr)
        initComponet()
        initListeners()
        focusChanged()
    }

    private fun focusChanged() {
        txtUserName.setOnFocusChangeListener { V, hasFocus ->
            if (hasFocus) {
                txtUserName.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_select))

            } else {
                txtUserName.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt))
            }
        }
        txtUser2.setOnFocusChangeListener { V, hasFocus ->
            if (hasFocus) {
                txtUser2.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_select))

            } else {
                txtUser2.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt))
            }
        }
        txtPass2.setOnFocusChangeListener { V, hasFocus ->
            if (hasFocus) {
                txtPass2.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_select))

            } else {
                txtPass2.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt))
            }
        }
        txtPassVerif.setOnFocusChangeListener { V, hasFocus ->
            if (hasFocus) {
                txtPassVerif.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_select))

            } else {
                txtPassVerif.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt))
            }
        }
    }
    private fun initComponet(){
        btnCancel = findViewById(R.id.btnCancel)
        btnRegist = findViewById(R.id.btnRegist)
        txtUserName = findViewById(R.id.txtUserName)
        txtUser2 = findViewById(R.id.txtUser2)
        txtPass2 = findViewById(R.id.txtPass2)
        txtPassVerif = findViewById(R.id.txtPassVerif)
    }
    private fun initListeners(){
        btnCancel.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
        btnRegist.setOnClickListener {
            if(checkCamp()){
                if(checkNetwork(this)){
                    saveDatos()
                    clear()
                    onBackPressedDispatcher.onBackPressed()
                }else
                {
                    Toast.makeText(this, "No conexion a internet, intente nuevamente", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun checkCamp():Boolean{
        val username = txtUserName.text.toString()
        val user = txtUser2.text.toString()
        val pass = txtPass2.text.toString()
        val passVeri = txtPassVerif.text.toString()

        return if(username.isEmpty() && user.isEmpty() && pass.isEmpty() && passVeri.isEmpty() ){
             caseCamp(1)
        }else if(username.isEmpty()){
             caseCamp(2)
        }else if(user.isEmpty()){
             caseCamp(3)
        }else if(pass.isEmpty()){
             caseCamp(4)
        }else if(passVeri.isEmpty()){
             caseCamp(5)
        }else if(user.length < 8){
             caseCamp(6)
        }else if(pass.length < 6){
             caseCamp(7)
        }else if(compMayus(pass)){
             caseCamp(8)
        }else if(pass != passVeri){
             caseCamp(9)
        }else {
            caseCamp(0)
        }


    }
    private fun saveDatos(){
        pref.saveName(txtUserName.text.toString())
        pref.saveUsernaame(txtUser2.text.toString())
        pref.savePassword(txtPass2.text.toString())
        Toast.makeText(this,"Guardado con exito",Toast.LENGTH_SHORT).show()

    }
    private fun caseCamp(case: Int):Boolean{

        return when(case){
            0 -> true
            1 -> {
                txtUserName.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_error))
                txtUser2.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_error))
                txtPass2.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_error))
                txtPassVerif.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_error))
                Toast.makeText(this, "Rellenar todos los campos", Toast.LENGTH_SHORT).show()
                false
            }
            2 -> {
                txtUserName.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_error))
                Toast.makeText(this, "Rellenar todos los campos", Toast.LENGTH_SHORT).show()
                false
            }
            3->{
                txtUser2.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_error))
                Toast.makeText(this, "Rellenar todos los campos", Toast.LENGTH_SHORT).show()
                false
            }
            4 ->{
                txtPass2.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_error))
                Toast.makeText(this, "Rellenar todos los campos", Toast.LENGTH_SHORT).show()
                false
            }
            5 -> {
                txtPassVerif.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_error))
                Toast.makeText(this, "Rellenar todos los campos", Toast.LENGTH_SHORT).show()
                false
            }
            6-> {
                txtUser2.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_error))
                Toast.makeText(this, "El usuario necesita al menos 8 caracteres", Toast.LENGTH_SHORT).show()
                false
            }
            7->{
                txtPass2.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_error))
                Toast.makeText(this, "La contraseña necesita al menos 6 caracteres", Toast.LENGTH_SHORT).show()
                false
            }
            8-> {
                txtPass2.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_error))
                Toast.makeText(this, "La contraseña debe contener una mayuscula", Toast.LENGTH_SHORT).show()
                false
            }
            9 ->{
                txtPass2.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_error))
                txtPassVerif.setBackgroundDrawable(ContextCompat.getDrawable(this , R.drawable.border_txt_error))
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                false
            }
            else -> true
        }

    }
    private fun compMayus(pass: String):Boolean{
        pass.forEach {
            if(it.isUpperCase())
                return false
        }
        return true

    }
    private fun clear(){
        txtUserName.text = null
        txtUser2.text = null
        txtPass2.text = null
        txtPassVerif.text = null
    }
    private fun checkNetwork(context: Context): Boolean {
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