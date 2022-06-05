package com.example.chat.data.repository

import com.example.chat.data.database.room.MessageDao
import com.example.chat.domain.repositories.DeleteAllMessage
import javax.inject.Inject

class DeleteAllMessageImpl @Inject constructor(
    private val messageDao: MessageDao
) : DeleteAllMessage {
    override suspend fun deleteAll() = messageDao.deleteAll()
}