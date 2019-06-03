package com.example.carros.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.carros.ImageHelper
import com.example.carros.R
import com.example.carros.model.Cars
import com.example.carros.view.DatailActivity
import kotlinx.android.synthetic.main.row_car_list.view.*

class CarListAdapter(
    private val context: Context,
    private val listCar: ArrayList<Cars>
) : RecyclerView.Adapter<CarListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.row_car_list, p0, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listCar.size


    @SuppressLint("RestrictedApi")
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        val car = listCar[p1]
        p0.binData(car)

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val modelo: TextView = itemView.text_modelCar
        val detail: TextView = itemView.view_detail
        val image : ImageView = itemView.image_car

        fun binData(car: Cars) {
            modelo.text = car.model
            image.setImageDrawable(car.picture)
            detail.setOnClickListener {

                val intent: Intent = Intent(context, DatailActivity::class.java)

                val bundle: Bundle = Bundle()
                bundle.putString("marca", car.manuFacturer)
                bundle.putString("modelo",car.model)
                bundle.putString("cavalos",car.horsePower)
                bundle.putString("preco", car.price)
                bundle.putInt("image", car.pictureIntResource!!)

                intent.putExtras(bundle)

                startActivity(context, intent, null)
            }
        }
    }
}









