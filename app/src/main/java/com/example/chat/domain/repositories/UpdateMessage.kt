package com.example.chat.domain.repositories

import com.example.chat.domain.model.Message

interface UpdateMessage {
    suspend fun update(message: Message)
}