package com.guiller.prueba_tecnica.datoApi

data class dataApiItem(
    val batters: Batters,
    val id: String,
    val name: String,
    val ppu: Double,
    val topping: List<Topping>,
    val type: String
)
//data class dataApiItem(
//    val batters: Batters,
//    val id: String,
//    val name: String,
//    val ppu: Double,
//    val topping: List<Topping>,
//    val type: String
//)