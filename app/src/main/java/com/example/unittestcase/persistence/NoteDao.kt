package com.example.unittestcase.persistence

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.unittestcase.model.Note
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface NoteDao {
    @Insert
    fun insertNote(note: Note): Single<Long>

    @Update
    fun updateNote(note: Note): Single<Int>

    @Delete
    fun deleteNote(note: Note): Single<Int>

    @Query("DELETE FROM notes")
    fun deleteAllNote(): Single<Int>

    @Query("SELECT * FROM notes")
    fun readAllNote(): Flowable<List<Note>>
}