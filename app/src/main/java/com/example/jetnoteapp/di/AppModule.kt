package com.example.jetnoteapp.di

import android.content.Context
import androidx.room.Room
import com.example.jetnoteapp.model.NoteDao
import com.example.jetnoteapp.model.NoteDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideNoteDao(noteDataBase: NoteDataBase) : NoteDao = noteDataBase.noteDao()

    @Singleton
    @Provides
    fun provideNoteDatabase(@ApplicationContext context: Context):NoteDataBase =
        Room.databaseBuilder(context , NoteDataBase::class.java , "note_db")
            .fallbackToDestructiveMigration()
            .build()
}