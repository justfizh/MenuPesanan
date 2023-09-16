package com.test.myapplication

data class MenuCafe(
    val kode: String = "",
    val jenis: String = "",
    val nama: String = "",
    val penjelasan: String = "",
    val harga: String = "",
) {
    companion object{
        fun empty() : MenuCafe = MenuCafe()
    }
}