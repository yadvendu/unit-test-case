package com.example.unittestcase.di

import com.example.unittestcase.persistence.NoteDao
import com.example.unittestcase.repository.NoteRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object MainActivityModule {

    @MainScope
    @Provides
    @JvmStatic
    fun providesNoteRepo(noteDao: NoteDao): NoteRepository = NoteRepository(noteDao)
}
