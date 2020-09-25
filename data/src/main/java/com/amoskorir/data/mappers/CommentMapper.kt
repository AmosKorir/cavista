package com.amoskorir.data.mappers

import com.amoskorir.data.sql.entities.CommentDbModel
import com.amoskorir.domain.models.Comment

class CommentMapper {
    companion object {
        fun transform(commentDb:CommentDbModel): Comment {
            return Comment(
                commentDb.commentId,
                commentDb.commentMessage,
                commentDb.commentMessage)
        }
    }
}