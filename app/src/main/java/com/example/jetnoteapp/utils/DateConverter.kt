package com.example.jetnoteapp.utils

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    @TypeConverter
    fun timeStampFromDate(date : Date):Long{
        return date.time
    }

    @TypeConverter
    fun dateToTimeStamp(timeStamp : Long):Date{
        return Date(timeStamp)
    }
}