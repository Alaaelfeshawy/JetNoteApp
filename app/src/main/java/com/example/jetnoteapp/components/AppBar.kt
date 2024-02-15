package com.example.jetnoteapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetnoteapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(content : @Composable ()->Unit = {}) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(12.dp),
                title = { Text(text = stringResource(R.string.app_name) , style = TextStyle(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 28.sp
                )
                ) } ,
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(0xFFDADFE3)
                )
            )
        }
    ) {
        Column(modifier = Modifier.padding(it)){
            content()
        }
    }
}