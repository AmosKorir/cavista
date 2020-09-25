package com.amoskorir.data.di

import com.amoskorir.data.repositories.apirepository.ImageApiRepository
import com.amoskorir.data.repositories.dbrpositories.ImageDbRepository
import com.amoskorir.domain.DiConstants
import com.amoskorir.domain.repositories.ImageRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

class RepositoryModule {
    companion object {
        val repositoryModule = module {
            single(named(DiConstants.IMAGE_API_REPOSITORY)) { ImageApiRepository(get()) as ImageRepository }
            single(named(DiConstants.IMAGE_DB_REPOSITORY)) { ImageDbRepository(get()) as ImageRepository }
        }
    }
}