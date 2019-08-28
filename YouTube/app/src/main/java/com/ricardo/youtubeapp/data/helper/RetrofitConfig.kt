package com.ricardo.youtubeapp.data.helper

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(YouTubeConfig().URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}