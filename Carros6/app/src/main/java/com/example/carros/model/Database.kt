package com.example.carros.model

import androidx.lifecycle.MutableLiveData
import com.example.carros.R

class Database {

    private val mDatabase : MutableLiveData<MutableList<Cars>> = MutableLiveData()

    fun listCar(listaCar :MutableList<Cars>):MutableLiveData<MutableList<Cars>>{

      addCar(listaCar!!)

        return mDatabase
    }

    fun addCar(listaCar : MutableList<Cars>?) : MutableList<Cars>?{

        listaCar?.add(Cars(1, "Audi R8", "Audi", "610 CV","R$ 1.165.338,00", R.drawable.audir8))
        listaCar?.add(Cars(2, "Bugatti", "Bugatti", "520","R$ 1.000.000,00", R.drawable.bugattichiron))
        listaCar?.add(Cars(3, "Civic Type R", "Honda", "310","R$ 130.000,00",R.drawable.civictyper))
        listaCar?.add(Cars(4, "Corolla", "Toyota", "144","R$ 161.000,00", R.drawable.corolla))
        listaCar?.add(Cars(5, "Ferrari 458 Italia", "Ferrari", "670","R$ 1.5000.000,00", R.drawable.ferrari458))
        listaCar?.add(Cars(6, "Ferrari F60 America", "Ferrari", "700","R$ 2.5000.000,00", R.drawable.ferrarif60america))
        listaCar?.add(Cars(7, "Jaguar F-Type Coupe", "Jaguar", "340","R$ 300.000,00", R.drawable.jaguarftype))
        listaCar?.add(Cars(8, "Jeep Renegade", "Jeep", "139","R$ 79.000,00", R.drawable.jeeprenegade))
        listaCar?.add(Cars(9, "Lamborghini Aventador", "Lamborghini", "700","R$ 2.000.000,00", R.drawable.lamborghiniaventador))
        listaCar?.add(Cars(10, "McLaren MP4-12C", "McLaren", "625","R$ 2.200.000,00", R.drawable.mclarenmp412c))
        listaCar?.add(Cars(11, "Mustang", "Ford", "533","R$ 210.000,00", R.drawable.mustang))
        listaCar?.add(Cars(12, "Porsche 911", "Porsche" , "435","R$ 580.000,00", R.drawable.porsche911))
        listaCar?.add(Cars(13, "Range Rover Evoque", "Range Rover", "285","R$ 224.000,00", R.drawable.rangerover))
        listaCar?.add(Cars(14, "Vanquish", "Aston Martin", "573","R$ 1.350.000,00", R.drawable.vanquish))

        return listaCar
    }

}