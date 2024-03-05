package com.guiller.prueba_tecnica.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guiller.prueba_tecnica.R
import com.guiller.prueba_tecnica.api.Batter

class batterDetalleval (val listadatos: List<Batter>): RecyclerView.Adapter<batterHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): batterHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return batterHolder(layoutInflater.inflate(R.layout.item_detalle, parent, false))
    }

    override fun getItemCount(): Int = listadatos.size  ///Tamano de la lista para saber cuantos van a cargar


    override fun onBindViewHolder(holder: batterHolder, position: Int) { //Pasa por cada uno de los items y devuelve la posicion
        val item = listadatos[position]
        holder.render(item)

    }
}