package com.ricardo.youtubeapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PageInfo {

    @SerializedName("totalResults")
    @Expose
    var totalResults: Int? = null
    @SerializedName("resultsPerPage")
    @Expose
    var resultsPerPage: Int? = null

}
