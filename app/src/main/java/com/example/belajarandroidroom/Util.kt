package com.example.belajarandroidroom

import android.content.Context
import androidx.room.Room
import com.example.belajarandroidroom.model.TodoDatabase

val DB_NAME = "newtododb"

fun buildDB(context: Context): TodoDatabase =
    Room.databaseBuilder(context.applicationContext,
        TodoDatabase::class.java,
        DB_NAME
    ).build()