package com.example.chat.domain.interactor

import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import com.example.chat.R
import com.example.chat.domain.model.Message
import com.example.chat.domain.repositories.DeleteAllMessage
import com.example.chat.domain.repositories.InsertMessage
import com.example.chat.domain.repositories.Repository
import com.example.chat.domain.usecases.InsertUseCase
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

interface ChatInteractor : Repository, InsertMessage, DeleteAllMessage {

    fun date(): String

    fun changeTheme(icon: Int): Int

    fun changeListAlignment(user: Boolean): Alignment.Horizontal

    fun changeUserColor(user: Boolean, one: Color, two: Color): Color

    class Base @Inject constructor(
        private val repository: Repository,
        private val insert: InsertUseCase,
        private val deleteAll: DeleteAllMessage,
    ) : ChatInteractor {

        override fun date(): String =
            SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())

        override fun changeTheme(icon: Int): Int =
            if (icon == darkIconTheme) lightIconTheme else darkIconTheme

        override fun changeListAlignment(user: Boolean): Alignment.Horizontal =
            if (user) Alignment.End else Alignment.Start

        override fun changeUserColor(user: Boolean, one: Color, two: Color): Color =
            if (user) two else one

        override fun message(): LiveData<List<Message>> = repository.message()

        override suspend fun insert(message: Message) = insert.insert(message)

        override suspend fun deleteAll() = deleteAll.deleteAll()
    }

    companion object {
        const val lightIconTheme = R.drawable.ic_baseline_brightness_1_24
        const val darkIconTheme = R.drawable.ic_baseline_brightness_2_24
    }
}