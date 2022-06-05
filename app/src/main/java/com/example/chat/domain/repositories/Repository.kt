package com.example.chat.domain.repositories

import androidx.lifecycle.LiveData
import com.example.chat.domain.model.Message

interface Repository {
    fun message(): LiveData<List<Message>>
}
