package com.example.chat.ui.screens.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chat.domain.interactor.ChatInteractor
import com.example.chat.domain.model.Message
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val interactor: ChatInteractor,
    private val dispatcher: CoroutineContext
) : ViewModel() {

    val message: LiveData<List<Message>> = interactor.message()

    fun insert(newMessage: Message): Job =
        viewModelScope.launch(dispatcher) {
            interactor.insert(newMessage)
        }

    fun deleteAll(): Job =
        viewModelScope.launch(dispatcher) {
            interactor.deleteAll()
        }

    fun changeUse(icon: Int, dark: Int, light: Int): Int =
        if (icon == dark) light else dark

    fun date(): String {
        val currentDate = Date()

        val timeFormat: DateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        return timeFormat.format(currentDate)
    }
}