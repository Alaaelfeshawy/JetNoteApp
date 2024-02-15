package com.example.jetnoteapp.repository

import com.example.jetnoteapp.model.NoteDao
import com.example.jetnoteapp.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {

    fun getAllNotes() : Flow<List<NoteModel>> = noteDao.getAllNotes().flowOn(Dispatchers.IO).conflate()

    suspend fun addNote(noteModel: NoteModel) = noteDao.addNote(noteModel)

    suspend fun deleteNote(noteModel: NoteModel) = noteDao.removeNote(noteModel)

    suspend fun deleteAllNotes() = noteDao.deleteAllNotes()

    suspend fun updateNote(noteModel: NoteModel) = noteDao.update(noteModel)

}