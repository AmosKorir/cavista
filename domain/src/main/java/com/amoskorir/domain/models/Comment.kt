package com.amoskorir.domain.models

data class Comment(
    val commentId: Int,
    val postId: String,
    val comment: String
)