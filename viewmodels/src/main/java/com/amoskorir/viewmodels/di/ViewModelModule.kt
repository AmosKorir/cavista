package com.amoskorir.viewmodels.di

import com.amoskorir.data.di.DataModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class ViewModelModule {
    companion object {
        val dataModulePass = DataModule
        val viewModelModule = module {

        }
    }
}