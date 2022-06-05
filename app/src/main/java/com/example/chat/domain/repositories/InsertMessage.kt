package com.example.chat.domain.repositories

import com.example.chat.domain.model.Message

interface InsertMessage {
    suspend fun insert(message: Message)
}