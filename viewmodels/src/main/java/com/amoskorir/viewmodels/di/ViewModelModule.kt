package com.amoskorir.viewmodels.di

import com.amoskorir.data.di.DataModule
import com.amoskorir.domain.DiConstants
import com.amoskorir.viewmodels.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

class ViewModelModule {
    companion object {
        val dataModulePass = DataModule
        val viewModelModule = module {
            viewModel {
                SearchViewModel(
                    get(named(DiConstants.IMAGE_API_REPOSITORY)),
                    get(named(DiConstants.IMAGE_DB_REPOSITORY))
                )
            }
        }
    }
}