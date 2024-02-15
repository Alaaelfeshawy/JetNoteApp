package com.example.jetnoteapp.screen.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetnoteapp.model.NoteModel
import com.example.jetnoteapp.utils.FormatDate
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

@Composable
fun NoteRow(modifier : Modifier = Modifier , noteModel: NoteModel , onNoteClicked : ()->Unit) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onNoteClicked() },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFDFE6EB)),
        shape = RoundedCornerShape(topEnd = 33.dp , bottomStart = 33.dp)
    ) {
        noteModel.title?.let { Text(modifier = modifier.padding(8.dp),text = it) }
        noteModel.note?.let { Text(modifier = modifier.padding(8.dp),text = it) }
        Text(modifier = modifier.padding(8.dp),text = FormatDate.formatDate(noteModel.dateEntry.time))

    }
}

