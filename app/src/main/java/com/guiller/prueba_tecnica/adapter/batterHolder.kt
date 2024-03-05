package com.guiller.prueba_tecnica.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.guiller.prueba_tecnica.api.Batter
import com.guiller.prueba_tecnica.api.Topping
import com.guiller.prueba_tecnica.databinding.ItemDetalleBinding

class batterHolder(view: View): RecyclerView.ViewHolder(view){

    val binding = ItemDetalleBinding.bind(view)



    fun render(datos: Batter){

        binding.txtIdF.text = datos.id
        binding.txtTypeF.text = datos.type
        itemView.setOnClickListener{  }
    }
}