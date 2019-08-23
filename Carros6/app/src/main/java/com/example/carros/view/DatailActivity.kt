package com.example.carros.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.example.carros.R
import kotlinx.android.synthetic.main.activity_datail.*

class DatailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datail)

        iniciarComponents()

        addDatail()
    }

    fun iniciarComponents(){

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.mipmap.ic_launcher)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun addDatail(){

        val marca: TextView = text_marca
        val model: TextView = text_model
        val horsePower: TextView = text_horse_power
        val price: TextView = text_price
        val imageDetail : ImageView = image_datail_car

        val bundle: Bundle = intent.extras
        val carMarca: String? = bundle.getString("marca")
        val carModelo: String? = bundle.getString("modelo")
        val carHorse: String? = bundle.getString("cavalos")
        val carPrice: String? = bundle.getString("preco")
        val imageCarDetail : Int = bundle.getInt("image")

        marca.text = carMarca
        model.text = carModelo
        horsePower.text = carHorse
        price.text = carPrice
        imageDetail.setImageResource(imageCarDetail)
    }
}
