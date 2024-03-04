package com.guiller.prueba_tecnica.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guiller.prueba_tecnica.R
import com.guiller.prueba_tecnica.classes.Datos

class datosAdapater(private val listadatos:List<Datos>): RecyclerView.Adapter<datosHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): datosHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return datosHolder(layoutInflater.inflate(R.layout.itme_datos, parent, false))
    }

    override fun getItemCount(): Int = listadatos.size  ///Tamano de la lista para saber cuantos van a cargar


    override fun onBindViewHolder(holder: datosHolder, position: Int) { //Pasa por cada uno de los items y devuelve la posicion
        val item = listadatos[position]
        holder.render(item)

    }

}