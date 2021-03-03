package com.example.unittestcase.di

import com.example.unittestcase.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @MainScope
    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity
}