package com.amoskorir.data.repositories.apirepository

import com.amoskorir.data.api.ImageApi
import com.amoskorir.data.mappers.ImageMapper
import com.amoskorir.domain.models.Comment
import com.amoskorir.domain.models.Image
import com.amoskorir.domain.repositories.ImageRepository
import io.reactivex.Flowable
import io.reactivex.Single

class ImageApiRepository(private val imageApi: ImageApi) : ImageRepository {
    override fun searchImages(string: String): Single<List<Image>> {
       return imageApi.searchImage(string)
           .map {it.data}
           .flatMapPublisher { Flowable.fromIterable(it) }
           .map {  ImageMapper.transform(it)}
           .toList()
//        val image=Image("dfh","dfbjh")
//        return Single.just( listOf(image,image,image))

    }

    override fun getImageComments(imageId: String): Single<List<Comment>> {
        TODO("Not yet implemented")
    }

    override fun commentImage(comment: Comment): Single<Int> {
        TODO("Not yet implemented")
    }

    override fun comment(imageId: String, comment: String): Single<Long> {
        TODO("Not yet implemented")
    }

}