package com.amoskorir.data.apiresponse


import com.google.gson.annotations.SerializedName

data class Processing(
    @SerializedName("status")
    val status: String
)