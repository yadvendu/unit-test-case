package com.example.unittestcase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.android.DaggerActivity

class MainActivity : DaggerActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}