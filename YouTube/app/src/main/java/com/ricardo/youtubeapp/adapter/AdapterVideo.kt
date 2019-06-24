package com.ricardo.youtubeapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ricardo.youtubeapp.R
import com.ricardo.youtubeapp.model.Item
import com.ricardo.youtubeapp.model.Snippet
import com.ricardo.youtubeapp.model.Video
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_video.view.*

class AdapterVideo(private  val context: Context,
    private val listaVideos: ArrayList<Item>
) : RecyclerView.Adapter<AdapterVideo.MyViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_video, p0, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = listaVideos.size

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {

        val video : Item = listaVideos[p1]
        p0.titulo.text = video.snippet?.title

        val url : String? = video.snippet?.thumbnails?.high?.url
        Picasso.get().load(url).into(p0.imagem)

    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imagem : ImageView = itemView.imageCapa
        val titulo : TextView = itemView.textTitulo
    }


}

