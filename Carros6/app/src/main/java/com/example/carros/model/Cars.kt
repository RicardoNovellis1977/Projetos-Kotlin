package com.example.carros.model

import android.graphics.drawable.Drawable
import java.io.Serializable

data class Cars(
    val id: Int,
    val model: String,
    val manuFacturer: String,
    val horsePower:String,
    val price:String,
    val picture: Drawable?,
    val pictureIntResource: Int?
): Serializable

