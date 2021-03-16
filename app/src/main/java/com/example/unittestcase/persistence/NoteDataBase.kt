package com.example.unittestcase.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.unittestcase.model.Note

@Database(
        entities = [Note::class],
        version = 1
)
abstract class NoteDataBase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object{
        private const val DATABASE_NAME = "note_db"
        private var instance: NoteDataBase? = null

        fun getAppDataBaseInstance(context: Context): NoteDataBase{
            if (instance == null){
                synchronized(NoteDataBase::class){
                    instance = Room.databaseBuilder(
                            context,
                            NoteDataBase::class.java,
                            DATABASE_NAME
                    )
                            .fallbackToDestructiveMigration()
                            .build()
                }
            }
            return instance!!
        }
    }
}