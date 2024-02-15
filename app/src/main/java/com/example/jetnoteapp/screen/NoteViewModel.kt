package com.example.jetnoteapp.screen

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnoteapp.model.NoteModel
import com.example.jetnoteapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor (private val repo : NoteRepository): ViewModel() {

    private val _notes = MutableStateFlow<List<NoteModel>>(emptyList())
    val notes  = _notes.asStateFlow()

    init {
        getAllNotes()
    }
    fun addNote(noteModel: NoteModel){
       viewModelScope.launch {
           repo.addNote(noteModel)
       }
    }
    fun updateNote(noteModel: NoteModel){
       viewModelScope.launch {
           repo.updateNote(noteModel)
       }
    }

    fun removeNote(noteModel: NoteModel){
       viewModelScope.launch {
           repo.deleteNote(noteModel)
       }
    }

    fun deleteAllNotes(){
       viewModelScope.launch {
           repo.deleteAllNotes()
       }
    }

    private fun getAllNotes(){
        viewModelScope.launch {
            repo.getAllNotes().collect{
                _notes.value = it
            }
        }
    }
}