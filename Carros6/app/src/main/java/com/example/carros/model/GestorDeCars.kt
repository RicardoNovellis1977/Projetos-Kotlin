package com.example.carros.model

class GestorDeCars(val database: Database)  {

    fun getCars(mCars : MutableList<Cars>?  ):MutableList<Cars>? {

        database.listCar(mCars)

        return mCars
    }
}