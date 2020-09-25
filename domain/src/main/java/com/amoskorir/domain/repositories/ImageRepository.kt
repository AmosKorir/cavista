package com.amoskorir.domain.repositories

import com.amoskorir.domain.models.Comment
import com.amoskorir.domain.models.Image
import com.amoskorir.domain.models.ImageWrapper
import io.reactivex.Single

interface ImageRepository {

    fun searchImages(string: String): Single<List<Image>>

    fun getImageComments(imageId: String): Single<List<Comment>>

    fun commentImage(comment: Comment): Single<Int>

    fun comment(imageId: String, comment: String): Single<Long>

}