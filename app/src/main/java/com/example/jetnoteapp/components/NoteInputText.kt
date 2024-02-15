package com.example.jetnoteapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp


@Composable
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
fun NoteInputText(
    modifier : Modifier = Modifier,
    title: String,
    label : String,
    onTextChange : (String)->Unit,
    maxLines : Int = 1,
    onImeAction: ()->Unit={}
) {
    val keyboard = LocalSoftwareKeyboardController.current

    TextField(
        modifier = modifier ,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White
        ),
        value = title,
        label = { Text(text = label) },
        onValueChange = {
            onTextChange(it)
        },
        maxLines = maxLines,
        keyboardActions = KeyboardActions(
            onDone = {
                onImeAction()
                keyboard?.hide()
            }
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        )
    )
}

