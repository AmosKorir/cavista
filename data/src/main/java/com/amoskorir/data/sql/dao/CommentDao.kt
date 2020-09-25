package com.amoskorir.data.sql.dao

import androidx.room.*
import com.amoskorir.data.sql.entities.CommentDbModel
import io.reactivex.Single

@Dao
interface CommentDao {
    @Query("SELECT * FROM comments WHERE imageId = :imageId")
    fun getComment(imageId: String): Single<List<CommentDbModel>>

    @Delete
    fun deleteComment(comment: CommentDbModel): Single<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertComment(comment: CommentDbModel): Single<Long>
}