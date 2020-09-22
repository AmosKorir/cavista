package com.amoskorir.data.apiresponse


import com.google.gson.annotations.SerializedName

data class AdConfig(
    @SerializedName("highRiskFlags")
    val highRiskFlags: List<Any>,
    @SerializedName("safeFlags")
    val safeFlags: List<String>,
    @SerializedName("showsAds")
    val showsAds: Boolean,
    @SerializedName("unsafeFlags")
    val unsafeFlags: List<String>,
    @SerializedName("wallUnsafeFlags")
    val wallUnsafeFlags: List<Any>
)