package com.example.unittestcase.repository

import com.example.unittestcase.model.Note
import com.example.unittestcase.persistence.NoteDao
import com.example.unittestcase.ui.Result
import io.reactivex.Flowable

import io.reactivex.Single
import java.lang.Exception

class NoteRepository(private val noteDao: NoteDao) {

    fun insertNote(note: Note): Single<Result<Boolean>> {
        return noteDao.insertNote(note)
                .map<Result<Boolean>> {
                    Result.Success(true)
                }
                .onErrorReturn {
                    Result.Error(it)
                }
    }
}