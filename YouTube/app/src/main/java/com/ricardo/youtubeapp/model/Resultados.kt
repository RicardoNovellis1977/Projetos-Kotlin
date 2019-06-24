package com.ricardo.youtubeapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Resultados() {


    @SerializedName("kind")
    @Expose
     var kind: String? = null
    @SerializedName("etag")
    @Expose
     var etag: String? = null
    @SerializedName("nextPageToken")
    @Expose
     var nextPageToken: String? = null
    @SerializedName("regionCode")
    @Expose
     var regionCode: String? = null
    @SerializedName("pageInfo")
    @Expose
     var pageInfo: PageInfo? = null
    @SerializedName("items")
    @Expose
     var items: List<Item>? = null

}