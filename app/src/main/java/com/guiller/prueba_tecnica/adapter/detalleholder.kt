package com.guiller.prueba_tecnica.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.guiller.prueba_tecnica.api.Batter
import com.guiller.prueba_tecnica.api.RespnseApiItem
import com.guiller.prueba_tecnica.api.Topping
import com.guiller.prueba_tecnica.databinding.ItemDetalleBinding
import com.guiller.prueba_tecnica.databinding.ItmeDatosBinding

class detalleholder(view: View): RecyclerView.ViewHolder(view){

    val binding = ItemDetalleBinding.bind(view)



    fun render(datos: Topping){

        binding.txtIdF.text = datos.id
        binding.txtTypeF.text = datos.type
        itemView.setOnClickListener{  }
    }
}