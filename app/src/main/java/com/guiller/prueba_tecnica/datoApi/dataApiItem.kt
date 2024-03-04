package com.guiller.prueba_tecnica.datoApi

data class dataApiItem(
    val batters: Batters,
    val id: String,
    val name: String,
    val ppu: Double,
    val topping: List<Topping>,
    val type: String
) : List<dataApiItem> {
    override val size: Int
        get() = TODO("Not yet implemented")

    override fun contains(element: dataApiItem): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<dataApiItem>): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(index: Int): dataApiItem {
        TODO("Not yet implemented")
    }

    override fun indexOf(element: dataApiItem): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<dataApiItem> {
        TODO("Not yet implemented")
    }

    override fun lastIndexOf(element: dataApiItem): Int {
        TODO("Not yet implemented")
    }

    override fun listIterator(): ListIterator<dataApiItem> {
        TODO("Not yet implemented")
    }

    override fun listIterator(index: Int): ListIterator<dataApiItem> {
        TODO("Not yet implemented")
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<dataApiItem> {
        TODO("Not yet implemented")
    }
}


//data class dataApiItem(
//    val batters: Batters,
//    val id: String,
//    val name: String,
//    val ppu: Double,
//    val topping: List<Topping>,
//    val type: String
//)