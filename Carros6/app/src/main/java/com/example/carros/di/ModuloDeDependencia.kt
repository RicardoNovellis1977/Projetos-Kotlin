package com.example.carros.di

import com.example.carros.model.Database
import com.example.carros.model.GestorDeCars
import com.example.carros.viewmodels.DetailViewModel
import com.example.carros.viewmodels.MainViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

object ModuloDeDependencia {

    val moduloApp = module {

        single { Database() }

        factory { GestorDeCars(get()) }

        viewModel { MainViewModel(get()) }
    }

    val moduloDetail = module {


        viewModel { DetailViewModel() }
    }
}