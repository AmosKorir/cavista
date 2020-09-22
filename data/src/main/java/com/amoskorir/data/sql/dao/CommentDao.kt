package com.amoskorir.data.sql.dao

import androidx.room.*
import com.amoskorir.domain.models.Comment
import io.reactivex.Single

@Dao
interface CommentDao {
    @Query("SELECT * FROM comments WHERE imageId = :imageId")
    fun getCustomers(imageId: String): Single<List<Comment>>

    @Delete
    fun deleteCustomer(comment: Comment): Single<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCustomer(comment: Comment): Single<Long>
}