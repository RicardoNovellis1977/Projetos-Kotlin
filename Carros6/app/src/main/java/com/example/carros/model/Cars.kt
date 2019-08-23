package com.example.carros.model

import java.io.Serializable

data class Cars(
    val id: Int? = null,
    val model: String? = null,
    val manuFacturer: String? = null,
    val horsePower:String? = null,
    val price:String? = null,
    val pictureIntResource: Int? = null
): Serializable

