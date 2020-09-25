package com.amoskorir.data.sql.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
@Entity(tableName = "comments")
data class CommentDbModel(
    @PrimaryKey @NotNull
    val commentId: String,
    val imageId: String,
    val commentMessage: String
)