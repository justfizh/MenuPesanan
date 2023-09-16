package com.test.myapplication

import AdapterMenu
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListMenu : AppCompatActivity() {
    private var listMenu: MutableList<MenuCafe> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_menu)
        setupData()
    }

    private fun setupData(){
        listMenu.add(
            MenuCafe(
               kode = "B01",
               jenis = "Minuman",
               nama = "Kopi Hitam",
               penjelasan = "Kopi Hitam Kupu - Kupu, Kopi hitam Semangatku",
               harga = "10000"
            )
        )
        listMenu.add(
            MenuCafe(
                kode = "B02",
                jenis = "Minuman",
                nama = "Cappucino",
                penjelasan = "Paduan Kopi yang sangat nikmat",
                harga = "20000"
            )
        )
        listMenu.add(
            MenuCafe(
                kode = "M03",
                jenis = "Minuman",
                nama = "Sparkling Tea",
                penjelasan = "Minuman teh dari gunung salak",
                harga = "15000"
            )
        )
        listMenu.add(
            MenuCafe(
                kode = "F01",
                jenis = "Makanan",
                nama = "Batagor",
                penjelasan = "Bakso Tahu Digoreng Haneut",
                harga = "25000"
            )
        )
        listMenu.add(
            MenuCafe(
                kode = "F02",
                jenis = "Makanan",
                nama = "Cireng",
                penjelasan = "Cireng Haneut Maknyuss",
                harga = "10000"
            )
        )
        listMenu.add(
            MenuCafe(
                kode = "F03",
                jenis = "Makanan",
                nama = "Nasi Goreng",
                penjelasan = "Di goreng dadakan",
                harga = "50000"
            )
        )
        listMenu.add(
            MenuCafe(
                kode = "D01",
                jenis = "Dessert",
                nama = "Chesse Cake",
                penjelasan = "Kue Tart Enaak",
                harga = "40000"
            )
        )
        listMenu.add(
            MenuCafe(
                kode = "D02",
                jenis = "Dessert",
                nama = "Black Salad",
                penjelasan = "Potongan Buah Buahan",
                harga = "30000"
            )
        )
        val adapterMenu = AdapterMenu(listMenu)
        val rvListProduct = findViewById<RecyclerView>(R.id.rv_list_menu)
        rvListProduct.apply {
            layoutManager = LinearLayoutManager(this@ListMenu)
            adapter = adapterMenu
        }
    }
}