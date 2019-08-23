package com.example.carros.view

import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.carros.R
import com.example.carros.view.adapter.CarListAdapter
import com.example.carros.model.Cars
import com.example.carros.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {


    private val listCar: MutableList<Cars> = arrayListOf<Cars>()
    private val mainViewModel: MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciarViews()

        mainViewModel.getCars(listCar)

    }

    fun iniciarViews() {

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.mipmap.ic_launcher)

        val recyclerCar: androidx.recyclerview.widget.RecyclerView = recycler_cars
        recyclerCar.adapter = CarListAdapter(this, listCar)
        recyclerCar.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
    }

}
