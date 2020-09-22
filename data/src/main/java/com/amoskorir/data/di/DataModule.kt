package com.amoskorir.data.di

import ApiModule
import org.koin.core.KoinComponent

class DataModule {
    companion object : KoinComponent {
        val apiModule = ApiModule.apiModule
        val repositoryModule = RepositoryModule.repositoryModule
    }
}