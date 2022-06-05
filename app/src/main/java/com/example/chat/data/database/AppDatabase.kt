package com.example.chat.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.chat.data.database.room.MessageDao
import com.example.chat.domain.model.Message
import javax.inject.Inject

@Database(entities = [Message::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun notesDao(): MessageDao
}
