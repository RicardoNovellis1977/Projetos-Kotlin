package com.example.carros.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.example.carros.R
import com.example.carros.viewmodels.DetailViewModel
import com.example.carros.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_datail.*
import org.koin.android.viewmodel.ext.android.viewModel

class DatailActivity : AppCompatActivity() {

    private val detailViewModel: DetailViewModel by viewModel()


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

        detailViewModel.getDetail(intent)

        text_marca.text = detailViewModel.carMarca
        text_model.text = detailViewModel.carModelo
        text_horse_power.text = detailViewModel.carHorse
        text_price.text = detailViewModel.carPrice
        image_datail_car.setImageResource(detailViewModel.imageCarDetail!!)
    }
}
