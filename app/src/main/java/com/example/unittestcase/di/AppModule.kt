package com.example.unittestcase.di

import android.app.Application
import com.example.unittestcase.persistence.NoteDao
import com.example.unittestcase.persistence.NoteDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @Singleton
    @Provides
    @JvmStatic
    fun provideNoteDao(application: Application): NoteDao? = NoteDataBase.getAppDataBaseInstance(application)?.noteDao()
}