package com.example.unittestcase.di

import androidx.lifecycle.ViewModelProvider
import com.example.unittestcase.ViewModelsProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindFactory(modelsProviderFactory: ViewModelsProviderFactory): ViewModelProvider.Factory
}