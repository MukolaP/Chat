package com.example.chat.domain.usecases

import android.content.Context
import android.widget.Toast
import com.example.chat.core.DoToast
import com.example.chat.domain.model.Message
import com.example.chat.domain.repositories.InsertMessage
import javax.inject.Inject

class InsertUseCase @Inject constructor(
    private val context: Context, private val toast: DoToast, private val insert: InsertMessage,
) : InsertMessage {

    override suspend fun insert(message: Message) =
        if (message.message == "       ")
            toast.doToast(context, toastError, toastLength)
        else insert.insert(message)

    private val toastError = "Please enter message !"

    private val toastLength = Toast.LENGTH_SHORT
}