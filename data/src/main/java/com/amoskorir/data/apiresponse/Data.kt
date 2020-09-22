package com.amoskorir.data.apiresponse


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("account_id")
    val accountId: Int,
    @SerializedName("account_url")
    val accountUrl: String,
    @SerializedName("ad_config")
    val adConfig: AdConfig,
    @SerializedName("ad_type")
    val adType: Int,
    @SerializedName("ad_url")
    val adUrl: String,
    @SerializedName("animated")
    val animated: Boolean,
    @SerializedName("bandwidth")
    val bandwidth: Int,
    @SerializedName("comment_count")
    val commentCount: Int,
    @SerializedName("cover")
    val cover: String,
    @SerializedName("cover_height")
    val coverHeight: Int,
    @SerializedName("cover_width")
    val coverWidth: Int,
    @SerializedName("datetime")
    val datetime: Int,
    @SerializedName("description")
    val description: String?,
    @SerializedName("downs")
    val downs: Int,
    @SerializedName("edited")
    val edited: Int,
    @SerializedName("favorite")
    val favorite: Boolean,
    @SerializedName("favorite_count")
    val favoriteCount: Int,
    @SerializedName("has_sound")
    val hasSound: Boolean,
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: List<Image>,
    @SerializedName("images_count")
    val imagesCount: Int,
    @SerializedName("in_gallery")
    val inGallery: Boolean,
    @SerializedName("in_most_viral")
    val inMostViral: Boolean,
    @SerializedName("include_album_ads")
    val includeAlbumAds: Boolean,
    @SerializedName("is_ad")
    val isAd: Boolean,
    @SerializedName("is_album")
    val isAlbum: Boolean,
    @SerializedName("layout")
    val layout: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("nsfw")
    val nsfw: Boolean,
    @SerializedName("points")
    val points: Int,
    @SerializedName("privacy")
    val privacy: String,
    @SerializedName("score")
    val score: Int,
    @SerializedName("section")
    val section: String,
    @SerializedName("size")
    val size: Int,
    @SerializedName("tags")
    val tags: List<Tag>,
    @SerializedName("title")
    val title: String,
    @SerializedName("topic")
    val topic: String,
    @SerializedName("topic_id")
    val topicId: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("ups")
    val ups: Int,
    @SerializedName("views")
    val views: Int,
    @SerializedName("vote")
    val vote: Any,
    @SerializedName("width")
    val width: Int
)