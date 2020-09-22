package com.amoskorir.data.api

import com.amoskorir.data.apiresponse.ImageApiResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApi {
    @GET("3/gallery/search")
    fun searchImage(@Query("q") searchString: String): Single<ImageApiResponse>
}