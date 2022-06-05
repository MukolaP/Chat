package com.example.chat.data.repository

import androidx.lifecycle.LiveData
import com.example.chat.data.database.room.MessageDao
import com.example.chat.domain.model.Message
import com.example.chat.domain.repositories.Repository
import javax.inject.Inject

class BaseRepository @Inject constructor(private val messageDao: MessageDao) : Repository {
    override fun message(): LiveData<List<Message>> = messageDao.getAll()
}



