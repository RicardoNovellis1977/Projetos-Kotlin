package com.example.carros.view

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.carros.R
import com.example.carros.adapter.CarListAdapter
import com.example.carros.model.Cars
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val listCar = arrayListOf<Cars>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.mipmap.ic_launcher)



        listCar.add(Cars(1, "Audi R8", "Audi", "610 CV","R$ 1.165.338,00", ContextCompat.getDrawable(baseContext,R.drawable.audir8),R.drawable.audir8))
        listCar.add(Cars(2, "Bugatti", "Bugatti", "520","R$ 1.000.000,00",ContextCompat.getDrawable(baseContext,R.drawable.bugattichiron),R.drawable.bugattichiron))
        listCar.add(Cars(3, "Civic Type R", "Honda", "310","R$ 130.000,00",ContextCompat.getDrawable(baseContext,R.drawable.civictyper),R.drawable.civictyper))
        listCar.add(Cars(4, "Corolla", "Toyota", "144","R$ 161.000,00",ContextCompat.getDrawable(baseContext,R.drawable.corolla),R.drawable.corolla))
        listCar.add(Cars(5, "Ferrari 458 Italia", "Ferrari", "670","R$ 1.5000.000,00",ContextCompat.getDrawable(baseContext,R.drawable.ferrari458),R.drawable.ferrari458))
        listCar.add(Cars(6, "Ferrari F60 America", "Ferrari", "700","R$ 2.5000.000,00",ContextCompat.getDrawable(baseContext,R.drawable.ferrarif60america),R.drawable.ferrarif60america))
        listCar.add(Cars(7, "Jaguar F-Type Coupe", "Jaguar", "340","R$ 300.000,00",ContextCompat.getDrawable(baseContext,R.drawable.jaguarftype),R.drawable.jaguarftype))
        listCar.add(Cars(8, "Jeep Renegade", "Jeep", "139","R$ 79.000,00",ContextCompat.getDrawable(baseContext,R.drawable.jeeprenegade),R.drawable.jeeprenegade))
        listCar.add(Cars(9, "Lamborghini Aventador", "Lamborghini", "700","R$ 2.000.000,00",ContextCompat.getDrawable(baseContext,R.drawable.lamborghiniaventador),R.drawable.lamborghiniaventador))
        listCar.add(Cars(10, "McLaren MP4-12C", "McLaren", "625","R$ 2.200.000,00",ContextCompat.getDrawable(baseContext,R.drawable.mclarenmp412c),R.drawable.mclarenmp412c))
        listCar.add(Cars(11, "Mustang", "Ford", "533","R$ 210.000,00",ContextCompat.getDrawable(baseContext,R.drawable.mustang),R.drawable.mustang))
        listCar.add(Cars(12, "Porsche 911", "Porsche" , "435","R$ 580.000,00",ContextCompat.getDrawable(baseContext,R.drawable.porsche911),R.drawable.porsche911))
        listCar.add(Cars(13, "Range Rover Evoque", "Range Rover", "285","R$ 224.000,00",ContextCompat.getDrawable(baseContext,R.drawable.rangerover),R.drawable.rangerover))
        listCar.add(Cars(14, "Vanquish", "Aston Martin", "573","R$ 1.350.000,00",ContextCompat.getDrawable(baseContext,R.drawable.vanquish),R.drawable.vanquish))



        val recyclerCar: RecyclerView = recycler_cars
        recyclerCar.adapter = CarListAdapter(this, listCar)
        recyclerCar.layoutManager = LinearLayoutManager(this)


    }

}
