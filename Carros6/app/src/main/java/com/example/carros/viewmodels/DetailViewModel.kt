package com.example.carros.viewmodels

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {

    var imageCarDetail: Int? = 0
    var carMarca: String? = ""
    var carModelo: String? = ""
    var carHorse: String? = ""
    var carPrice: String? = ""

    fun getDetail(intent: Intent) {

        val bundle: Bundle? = intent.extras
        carMarca = bundle?.getString("marca")
        carModelo = bundle?.getString("modelo")
        carHorse = bundle?.getString("cavalos")
        carPrice = bundle?.getString("preco")
        imageCarDetail = bundle?.getInt("image")

    }


}