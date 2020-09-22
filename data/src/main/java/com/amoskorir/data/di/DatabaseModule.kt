package com.amoskorir.data.di

import android.content.Context
import androidx.room.Room
import com.amoskorir.data.sql.CovistaDataBase
import com.amoskorir.data.sql.dao.CommentDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created by Korir on 1/11/20.
 * amoskrr@gmail.com
 */

class DatabaseModule {
    companion object {
        val databaseModule = module {
            fun provideDatabase(context: Context): CovistaDataBase {
                return Room.databaseBuilder(context, CovistaDataBase::class.java, "covista_db")
                    .fallbackToDestructiveMigration()
                    .build()
            }

            fun provideImageDao(covistaDataBase: CovistaDataBase): CommentDao {
                return covistaDataBase.commentDao()
            }


            single { provideDatabase(androidContext()) }
            single { provideImageDao(get()) }

        }
    }
}