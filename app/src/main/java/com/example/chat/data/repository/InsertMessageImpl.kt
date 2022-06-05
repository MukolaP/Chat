package com.example.chat.data.repository

import com.example.chat.data.database.room.MessageDao
import com.example.chat.domain.model.Message
import com.example.chat.domain.repositories.InsertMessage
import javax.inject.Inject

class InsertMessageImpl @Inject constructor(private val messageDao: MessageDao) : InsertMessage {
    override suspend fun insert(message: Message) = messageDao.insert(message)
}