package com.amoskorir.data.repositories.dbrpositories

import com.amoskorir.data.mappers.CommentMapper
import com.amoskorir.data.sql.dao.CommentDao
import com.amoskorir.data.sql.entities.CommentDbModel
import com.amoskorir.domain.models.Comment
import com.amoskorir.domain.models.Image
import com.amoskorir.domain.repositories.ImageRepository
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*

class ImageDbRepository(private val commentDao: CommentDao) : ImageRepository {
    override fun searchImages(string: String): Single<List<Image>> {
        TODO("Not yet implemented")
    }

    override fun getImageComments(imageId: String): Single<List<Comment>> {
        return commentDao.getComment(imageId)
            .flatMapPublisher { Flowable.fromIterable(it) }
            .map { CommentMapper.transform(it) }
            .toList()


    }

    override fun commentImage(comment: Comment): Single<Int> {
        TODO("Not yet implemented")
    }

    override fun comment(imageId: String, comment: String): Single<Long> {
        return Single.just(CommentDbModel(UUID.randomUUID().toString(), imageId, comment))
            .flatMap { commentDao.insertComment(it) }
    }

}