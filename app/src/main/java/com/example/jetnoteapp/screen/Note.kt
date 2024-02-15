package com.example.jetnoteapp.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.jetnoteapp.R
import com.example.jetnoteapp.components.AppBar
import com.example.jetnoteapp.components.NoteButton
import com.example.jetnoteapp.components.NoteInputText
import com.example.jetnoteapp.model.NoteModel
import com.example.jetnoteapp.screen.widgets.NoteRow

@Composable
fun NoteScreen(
    notes : List<NoteModel>,
    onAddNote : (NoteModel) -> Unit,
    onRemoveNote : (NoteModel) ->Unit

    ) {
    val context = LocalContext.current

    var title by remember{
        mutableStateOf("")
    }
    var note by remember{
        mutableStateOf("")
    }

    val noteMessage = stringResource(R.string.notes_added_successfully)

    AppBar{
      Column(
          modifier = Modifier.fillMaxWidth(),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
      ) {
          NoteInputText(modifier = Modifier.padding(
              top = 8.dp , bottom = 9.dp
          ), title = title , label = stringResource(R.string.title) , onTextChange = { title = it })
          NoteInputText(modifier = Modifier.padding(
              top = 8.dp , bottom = 9.dp
          ),title = note , label = stringResource(R.string.note) , onTextChange = { note = it })
          NoteButton(text = stringResource(R.string.save)){
              if (title.isNotBlank() && note.isNotBlank()) {
                  onAddNote(NoteModel(title = title, note = note))
                  title = ""
                  note = ""
                  Toast.makeText(context, noteMessage , Toast.LENGTH_SHORT).show()
              }
          }
      }

        Divider(Modifier.padding(10.dp))
        LazyColumn{
            items(notes){
                NoteRow(noteModel= it){
                    onRemoveNote(it)
                }
              }
          }
    }
}
