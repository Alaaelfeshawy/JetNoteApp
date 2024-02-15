package com.example.jetnoteapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date
import java.util.UUID

@Entity(tableName = "notes_tbl")
data class NoteModel(
    @PrimaryKey
    val id : UUID = UUID.randomUUID(),
    @ColumnInfo(name = "note_title")
    var title:String?=null,
    @ColumnInfo(name = "note_description")
    var note:String?=null,
    @ColumnInfo(name = "note_date")
    val dateEntry : Date = Date.from(Instant.now())
)