package com.example.unittestcase

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.unittestcase.model.Note
import com.example.unittestcase.persistence.NoteDao
import com.example.unittestcase.persistence.NoteDataBase
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering
import org.mockito.Mock

@RunWith(AndroidJUnit4::class)
class NoteDataBaseTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule() // Used when testing live data , not needed here as all have rxJava return type
    private lateinit var noteDataBase: NoteDataBase
    private lateinit var noteDao: NoteDao

    @Before
    fun setUp() {
        noteDataBase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NoteDataBase::class.java
        ).build()

        noteDao = noteDataBase.noteDao()
    }

    @Test
    fun insertNoteWithSuccess() {
        val note = getNote()
        noteDao.insertNote(note).test().assertValue {
            it == 1L
        }
    }

    @Test
    fun getNoteAndCompareWithInsertedNoteGivesSuccess() {
        noteDao.insertNote(getNote()).blockingGet()
        noteDao.readAllNote().test().assertValue {
            it[0].title == "Note"
        }
    }

    @Test
    fun updateNoteAfterInsertingNoteGivesSuccess() {
        noteDao.insertNote(getNote()).blockingGet()
        val notes = noteDao.readAllNote().blockingFirst()
        noteDao.updateNote(notes[0]).test().assertValue {
            it == 1
        }
    }

    @Test
    fun updateNoteAndCheckUpdateValueGiveSuccess() {
        noteDao.insertNote(getNote()).blockingGet()
        val notes = noteDao.readAllNote().blockingFirst()
        val updateNote = Note(notes[0].id, "New Title", notes[0].content, notes[0].timeStamp)
        noteDao.updateNote(updateNote).blockingGet()
        noteDao.readAllNote().test().assertValue {
            it[0].title == "New Title"
        }
    }

    @Test
    fun deleteSingleNoteGiveSuccess() {
        noteDao.insertNote(getNote()).blockingGet()
        noteDao.insertNote(getNote()).blockingGet()
        val notes = noteDao.readAllNote().blockingFirst()
        noteDao.deleteNote(notes[0]).test().assertValue {
            it == 1
        }
    }

    @Test
    fun deleteAllNoteGiveSuccess() {
        noteDao.insertNote(getNote()).blockingGet()
        noteDao.deleteAllNote().test().assertValue {
            it == 1
        }
    }

    @After
    fun tearDown() {
        noteDataBase.close()
    }

    private fun getNote(): Note {
        return Note(title = "Note", content = "This is note", timeStamp = "05-2020")
    }
}