package com.amoskorir.data.sql

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amoskorir.data.sql.dao.CommentDao
import com.amoskorir.data.sql.entities.CommentDbModel

@Database(entities = [CommentDbModel::class], version = 1)
abstract class CovistaDataBase : RoomDatabase() {

    abstract fun commentDao(): CommentDao
}