package com.example.chat.data.repository

import com.example.chat.data.database.room.MessageDao
import com.example.chat.domain.model.Message
import com.example.chat.domain.repositories.UpdateMessage
import javax.inject.Inject

class UpdateMessageImpl @Inject constructor(private val messageDao: MessageDao) : UpdateMessage {
    override suspend fun update(message: Message) = messageDao.update(message)
}