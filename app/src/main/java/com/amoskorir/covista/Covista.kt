package com.amoskorir.covista

import android.app.Application
import androidx.multidex.MultiDexApplication
import com.amoskorir.covista.di.ActivityModule.Companion.activityModule
import com.amoskorir.viewmodels.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Covista:MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        val modules = ViewModelModule.dataModulePass
        startKoin {
            androidContext(this@Covista)
            modules(
                listOf(
                    activityModule,
                    modules.apiModule,
                    modules.databaseModule,
                    modules.repositoryModule,
                    ViewModelModule.viewModelModule

                )
            )
        }

    }
}