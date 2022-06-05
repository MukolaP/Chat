package com.example.chat.ui.screens.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chat.domain.interactor.ChatInteractor
import com.example.chat.domain.model.Message
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
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

    fun changeUse(icon: Int, dark: Int, light: Int) =
        if (icon == dark) light else dark
}