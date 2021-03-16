package com.example.unittestcase.ui.noteslist

import android.os.Bundle
import android.util.Log
import com.example.unittestcase.R
import com.example.unittestcase.repository.NoteRepository
import dagger.android.DaggerActivity
import javax.inject.Inject

class MainActivity : DaggerActivity() {

    @Inject
    lateinit var noteRepository: NoteRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", noteRepository.toString())
    }
}