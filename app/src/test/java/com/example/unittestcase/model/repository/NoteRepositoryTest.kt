package com.example.unittestcase.model.repository

import com.example.unittestcase.model.Note
import com.example.unittestcase.persistence.NoteDao
import com.example.unittestcase.repository.NoteRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import io.reactivex.Single
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.lang.IndexOutOfBoundsException

class NoteRepositoryTest {

    @MockK
    private lateinit var noteDao: NoteDao

    private lateinit var noteRepository: NoteRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        noteRepository = NoteRepository(noteDao)
    }

    @Test
    fun `given noteDao insert note returns 1L, when insert row, noteDao insertNote called`() {
        //Given
        every { noteDao.insertNote(any()) } returns Single.just(1L)

        //When
        noteRepository.insertNote(getNote())

        //Then
        verify { noteDao.insertNote(getNote()) }
    }

    @Test
    fun `given noteDao insert note returns 1L, when insert row, then noteDao returns row equal to 1L`() {
        //Given
        every { noteDao.insertNote(any()) } returns Single.just(1L)

        //When
        val observer = noteRepository.insertNote(getNote()).test()

        //Then
        assertEquals(1L, observer.values()[0])
    }

    private fun getNote(): Note {
        return Note(title = "Note", content = "This is note", timeStamp = "05-2020")
    }
}