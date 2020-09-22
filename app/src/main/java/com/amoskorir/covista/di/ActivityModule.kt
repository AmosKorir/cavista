package com.amoskorir.covista.di
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.amoskorir.domain.CovistaConstants

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

class ActivityModule {
    companion object {
        val activityModule = module {
            single { provideSettingsPreferences(androidApplication()) }

        }
        private const val PREFERENCES_FILE_KEY = CovistaConstants.SHARED_PREFERENCE

        private fun provideSettingsPreferences(app: Application): SharedPreferences =
            app.getSharedPreferences(PREFERENCES_FILE_KEY, Context.MODE_PRIVATE)
    }
}
