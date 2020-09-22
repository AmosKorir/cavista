package com.amoskorir.data.apiresponse


import com.google.gson.annotations.SerializedName

data class ImageApiResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("status")
    val status: Int,
    @SerializedName("success")
    val success: Boolean
)