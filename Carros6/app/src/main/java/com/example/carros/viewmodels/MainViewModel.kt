package com.example.carros.viewmodels

import androidx.lifecycle.ViewModel
import com.example.carros.model.Cars
import com.example.carros.model.GestorDeCars

class MainViewModel(val gestorDeCars : GestorDeCars): ViewModel() {


    fun getCars (cars : MutableList<Cars>){

            gestorDeCars.getCars(cars)
    }

}