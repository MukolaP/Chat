package com.example.chat.domain.interactor

import androidx.lifecycle.LiveData
import com.example.chat.domain.model.Message
import com.example.chat.domain.repositories.DeleteAllMessage
import com.example.chat.domain.repositories.InsertMessage
import com.example.chat.domain.repositories.Repository
import com.example.chat.domain.usecases.InsertUseCase
import javax.inject.Inject

interface ChatInteractor : Repository, InsertMessage, DeleteAllMessage {

    class Base @Inject constructor(
        private val repository: Repository,
        private val insert: InsertUseCase,
        private val deleteAll: DeleteAllMessage,
    ) : ChatInteractor {

        override fun message(): LiveData<List<Message>> = repository.message()

        override suspend fun insert(message: Message) = insert.insert(message)

        override suspend fun deleteAll() = deleteAll.deleteAll()
    }
}