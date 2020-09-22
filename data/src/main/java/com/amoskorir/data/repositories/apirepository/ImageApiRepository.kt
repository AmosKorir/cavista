package com.amoskorir.data.repositories.apirepository

import com.amoskorir.domain.models.Comment
import com.amoskorir.domain.models.Image
import com.amoskorir.domain.repositories.ImageRepository
import io.reactivex.Single

class ImageApiRepository : ImageRepository {
    override fun searchImages(string: String): Single<List<Image>> {
        TODO("Not yet implemented")
    }

    override fun getImageComments(imageId: String): Single<List<Comment>> {
        TODO("Not yet implemented")
    }

    override fun commentImage(comment: Comment): Single<Int> {
        TODO("Not yet implemented")
    }

}