package com.example.jetnoteapp.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object FormatDate {

    fun formatDate(time : Long) : String{
        return   SimpleDateFormat("EEE , d MMM hh:mm aaa", Locale.getDefault()).format(Date(time))
    }
}