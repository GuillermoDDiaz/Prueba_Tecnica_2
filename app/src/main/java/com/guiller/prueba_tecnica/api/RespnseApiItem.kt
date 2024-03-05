package com.guiller.prueba_tecnica.api

data class RespnseApiItem(
    val batters: Batters,
    val id: String,
    val name: String,
    val ppu: Double,
    val topping: List<Topping>,
    val type: String
)