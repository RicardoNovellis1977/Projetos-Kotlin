package com.example.carros

import android.app.Application
import com.example.carros.di.ModuloDeDependencia
import org.koin.android.ext.android.startKoin

class MyAplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this,
            listOf(ModuloDeDependencia.moduloApp,
                ModuloDeDependencia.moduloDetail)
            )
    }
}