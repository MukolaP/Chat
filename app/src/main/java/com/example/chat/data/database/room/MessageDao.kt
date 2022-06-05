package com.example.chat.data.database.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.chat.domain.model.Message

@Dao
interface MessageDao {

    @Query("SELECT * FROM message")
    fun getAll(): LiveData<List<Message>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(notes: Message)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(notes: Message)

    @Query("DELETE FROM message")
    suspend fun deleteAll()
}
