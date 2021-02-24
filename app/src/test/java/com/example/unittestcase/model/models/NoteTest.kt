package com.example.unittestcase.model.models

import com.example.unittestcase.model.Note
import junit.framework.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.jupiter.api.Test

internal class NoteTest {
    companion object {
        const val TIME_STAMP_1 = "04-2020"
        const val TIME_STAMP_2 = "05-2020"
    }

    /*
    Compare two equal notes
     */
    @Test
    internal fun `given two notes with identical properties always return true`() {
        //Given
        val note1 = Note(1,"Note 1","This is note 1", TIME_STAMP_1)
        val note2 = Note(1,"Note 1","This is note 1", TIME_STAMP_1)

        //When

        //Then
        assertEquals(note1, note2)
    }

    /*
    Compare 2 notes with different ids
     */
    @Test
    internal fun `given two notes with different id always return false`() {
        //Given
        val note1 = Note(1,"Note 1","This is note 1", TIME_STAMP_1)
        val note2 = Note(2,"Note 1","This is note 1", TIME_STAMP_1)

        //When

        //Then
        assertNotEquals(note1, note2)
    }

    /*
    Compare two notes with different timestamp
     */
    @Test
    internal fun `given two notes with different time stamp will always return true`() {
        //Given
        val note1 = Note(1,"Note 1","This is note 1", TIME_STAMP_1)
        val note2 = Note(1,"Note 1","This is note 1", TIME_STAMP_2)

        //When

        //Then
        assertEquals(note1, note2)
    }

    /*
    Compare two notes with different title
     */
    @Test
    internal fun `given two notes with different title will always return false`() {
        //Given
        val note1 = Note(1,"Note 1","This is note 1", TIME_STAMP_1)
        val note2 = Note(1,"Note 2","This is note 1", TIME_STAMP_1)

        //When

        //Then
        assertNotEquals(note1, note2)
    }

    /*
    Compare two notes with different content
     */
    @Test
    internal fun `given two notes with different content will always return false`() {
        //Given
        val note1 = Note(1,"Note 1","This is note 1", TIME_STAMP_1)
        val note2 = Note(1,"Note 1","This is note 2", TIME_STAMP_1)

        //When

        //Then
        assertNotEquals(note1, note2)
    }
}
