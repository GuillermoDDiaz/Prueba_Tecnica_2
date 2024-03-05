package com.guiller.prueba_tecnica.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.guiller.prueba_tecnica.api.Batter
import com.guiller.prueba_tecnica.api.RespnseApi
import com.guiller.prueba_tecnica.api.RespnseApiItem
import com.guiller.prueba_tecnica.databinding.ItmeDatosBinding


class datosHolder (view:View): RecyclerView.ViewHolder(view){
    val binding = ItmeDatosBinding.bind(view)


    fun render(datos: RespnseApiItem, onclick:(RespnseApiItem)-> Unit){

        binding.txtIdF.text = datos.id
        binding.txtNameF.text = datos.name
        binding.txtPpuF.text = datos.ppu.toString()
        binding.txtTypeF.text = datos.type

        itemView.setOnClickListener{ onclick(datos) }
    }
}