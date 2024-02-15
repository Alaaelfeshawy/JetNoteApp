package com.example.jetnoteapp.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes_tbl")
    fun getAllNotes(): Flow<List<NoteModel>>

    @Query("select * from notes_tbl where id=:id")
    suspend fun getNoteById(id: String) : NoteModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(noteModel: NoteModel) : Long

    @Delete
    suspend fun removeNote(noteModel: NoteModel)

    @Query("delete from notes_tbl")
    suspend fun deleteAllNotes()

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(noteModel: NoteModel)
}