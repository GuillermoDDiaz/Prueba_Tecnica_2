package com.guiller.prueba_tecnica.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.guiller.prueba_tecnica.api.Batter
import com.guiller.prueba_tecnica.api.RespnseApi
import com.guiller.prueba_tecnica.api.RespnseApiItem
import com.guiller.prueba_tecnica.databinding.ItmeDatosBinding
import com.guiller.prueba_tecnica.inicio.InicioAppActivity.Companion.itemClick

class datosHolder (view:View): RecyclerView.ViewHolder(view){
    val binding = ItmeDatosBinding.bind(view)


    fun render(datos: RespnseApiItem, onclick:(RespnseApiItem)-> Unit){

        binding.txtId.text = datos.id
        binding.txtNames.text = datos.name
        binding.txtPpu.text = datos.ppu.toString()
        binding.txtType.text = datos.type

        itemView.setOnClickListener{ onclick(datos) }
    }
}