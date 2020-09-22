package com.amoskorir.data.apiresponse


import com.google.gson.annotations.SerializedName

/**
 * for this specific case, only required fields have been considered
 */
data class Image(
    @SerializedName("account_id")
    val accountId: Any,
    @SerializedName("account_url")
    val accountUrl: Any,
    @SerializedName("ad_type")
    val adType: Int,
    @SerializedName("ad_url")
    val adUrl: String,
    @SerializedName("animated")
    val animated: Boolean,
    @SerializedName("bandwidth")
    val bandwidth: Int,
    @SerializedName("comment_count")
    val commentCount: Any,
    @SerializedName("datetime")
    val datetime: Int,
    @SerializedName("description")
    val description: Any,
    @SerializedName("downs")
    val downs: Any,
    @SerializedName("edited")
    val edited: String,
    @SerializedName("favorite")
    val favorite: Boolean,
    @SerializedName("favorite_count")
    val favoriteCount: Any,
    @SerializedName("gifv")
    val gifv: String,
    @SerializedName("has_sound")
    val hasSound: Boolean,
    @SerializedName("height")
    val height: Int,
    @SerializedName("hls")
    val hls: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("in_gallery")
    val inGallery: Boolean,
    @SerializedName("in_most_viral")
    val inMostViral: Boolean,
    @SerializedName("is_ad")
    val isAd: Boolean,
    @SerializedName("link")
    val link: String,
    @SerializedName("looping")
    val looping: Boolean,
    @SerializedName("mp4")
    val mp4: String,
    @SerializedName("mp4_size")
    val mp4Size: Int,
    @SerializedName("nsfw")
    val nsfw: Any,
    @SerializedName("points")
    val points: Any,
    @SerializedName("processing")
    val processing: Processing,
    @SerializedName("score")
    val score: Any,
    @SerializedName("section")
    val section: Any,
    @SerializedName("size")
    val size: Int,
    @SerializedName("tags")
    val tags: List<Any>,
    @SerializedName("title")
    val title: String?,
    @SerializedName("type")
    val type: String,
    @SerializedName("ups")
    val ups: Any,
    @SerializedName("views")
    val views: Int,
    @SerializedName("vote")
    val vote: Any,
    @SerializedName("width")
    val width: Int
)