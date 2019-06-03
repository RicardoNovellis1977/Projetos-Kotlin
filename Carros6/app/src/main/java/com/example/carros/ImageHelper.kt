package com.example.carros

import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.util.Base64
import android.R
import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import java.io.ByteArrayOutputStream


class ImageHelper {

   fun convertStringToBitmap(imageString : String) : Bitmap{
        val decodedString = Base64.decode(imageString, Base64.DEFAULT)
        val decodedBitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
        return decodedBitmap
    }

    fun convertBitmapToString(context: Context, imageInt: Int): String{
        val baos = ByteArrayOutputStream()
        val bitmap = BitmapFactory.decodeResource(context.resources,imageInt)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val imageBytes = baos.toByteArray()
        val imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT)

        return imageString
    }

}