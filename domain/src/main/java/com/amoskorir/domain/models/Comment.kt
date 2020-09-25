package com.amoskorir.domain.models

data class Comment(
    val commentId: String,
    val postId: String,
    val comment: String
)