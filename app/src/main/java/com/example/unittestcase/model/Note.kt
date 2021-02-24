package com.example.unittestcase.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "notes")
internal data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @NonNull
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo(name = "timestamp")
    val timeStamp: String
) : Parcelable {
    override fun equals(other: Any?): Boolean {
        if (other == null) {
            return false
        }
        val note = other as Note
        return note.id == id && note.title == title && note.content == content
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}