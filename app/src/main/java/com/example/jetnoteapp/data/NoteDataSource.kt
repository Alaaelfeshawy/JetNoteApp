package com.example.jetnoteapp.data

import com.example.jetnoteapp.model.NoteModel

class NoteDataSource {
    fun loadNotes():List<NoteModel>{
        return listOf(
            NoteModel(title = "Studying", note = "Android Course"),
            NoteModel(title = "Eating", note = "Launch"),
            NoteModel(title = "Watching tv", note = "The Walking dead")
        )
    }
}