package com.ricardo.youtubeapp.API

import com.ricardo.youtubeapp.model.Resultados
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeService {

    @GET("search")
    fun recuperarVideos(
        @Query
            ("part") part: String,
        @Query
            ("order") order: String,
        @Query
            ("maxResults") maxResults: String,
        @Query
            ("key") key: String,
        @Query
            ("channelId") channelId: String,
        @Query
            ("q") q: String
    ): Call<Resultados>

}