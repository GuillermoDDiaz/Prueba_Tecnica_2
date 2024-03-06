package com.guiller.prueba_tecnica.interfac

import com.guiller.prueba_tecnica.api.Batter
import com.guiller.prueba_tecnica.api.RespnseApi
import com.guiller.prueba_tecnica.api.Topping

interface passFragDeta {
    fun getDatos(respons: RespnseApi, data: List<Topping>, dataB:List<Batter>)
}