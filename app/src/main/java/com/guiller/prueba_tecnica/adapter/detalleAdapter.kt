package com.guiller.prueba_tecnica.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guiller.prueba_tecnica.R
import com.guiller.prueba_tecnica.api.Batter
import com.guiller.prueba_tecnica.api.RespnseApi
import com.guiller.prueba_tecnica.api.RespnseApiItem
import com.guiller.prueba_tecnica.api.Topping

class detalleAdapter (val listadatos: List<Topping>): RecyclerView.Adapter<detalleholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): detalleholder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return detalleholder(layoutInflater.inflate(R.layout.item_detalle, parent, false))
    }

    override fun getItemCount(): Int = listadatos.size  ///Tamano de la lista para saber cuantos van a cargar


    override fun onBindViewHolder(holder: detalleholder, position: Int) { //Pasa por cada uno de los items y devuelve la posicion
        val item = listadatos[position]
        holder.render(item)

    }
}