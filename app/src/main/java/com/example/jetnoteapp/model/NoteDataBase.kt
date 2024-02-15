package com.example.jetnoteapp.model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jetnoteapp.utils.DateConverter

@TypeConverters(DateConverter::class)
@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {

    abstract fun noteDao():NoteDao
}