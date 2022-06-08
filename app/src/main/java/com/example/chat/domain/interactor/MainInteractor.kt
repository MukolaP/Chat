package com.example.chat.domain.interactor

import android.content.Context
import android.widget.Toast
import com.example.chat.app.nickname
import com.example.chat.core.DoToast
import javax.inject.Inject

interface MainInteractor {

    suspend fun auditLoginButton(message: String)

    class Base @Inject constructor(
        private val toast: DoToast,
        private val context: Context,
    ) : MainInteractor {

        override suspend fun auditLoginButton(message: String) {
            if (message.isNotEmpty()) {
                nickname = message
            } else
                toast.doToast(context, toastError, toastLength)
        }

        private val toastError = "Please enter nickname !"

        private val toastLength = Toast.LENGTH_SHORT

    }
}
