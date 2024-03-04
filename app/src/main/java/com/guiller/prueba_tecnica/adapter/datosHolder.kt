package com.guiller.prueba_tecnica.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.guiller.prueba_tecnica.classes.Datos
import com.guiller.prueba_tecnica.databinding.ItmeDatosBinding
import com.guiller.prueba_tecnica.datoApi.dataApi
import com.guiller.prueba_tecnica.datoApi.dataApiItem

class datosHolder (view:View): RecyclerView.ViewHolder(view){
    val binding = ItmeDatosBinding.bind(view)

    fun render(datos: dataApiItem){
        binding.txtId.text = datos.id
        binding.txtNames.text = datos.name
        binding.txtPpu.text = datos.ppu.toString()
        binding.txtType.text = datos.type
    }
}