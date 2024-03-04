package com.guiller.prueba_tecnica.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.guiller.prueba_tecnica.R
import com.guiller.prueba_tecnica.classes.Datos

class datosHolder (view:View): RecyclerView.ViewHolder(view){
    val name1 = view.findViewById<TextView>(R.id.name)
    val apellido = view.findViewById<TextView>(R.id.apellido)
    val imgA = view.findViewById<ImageView>(R.id.imgA)

    fun render(datos: Datos){
        name1.text = datos.superH
        apellido.text = datos.apellido


    }
}