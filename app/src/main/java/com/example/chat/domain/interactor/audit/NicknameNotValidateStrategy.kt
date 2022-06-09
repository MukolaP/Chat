package com.example.chat.domain.interactor.audit

import android.content.Context
import android.widget.Toast
import com.example.chat.core.DoToast
import com.example.chat.core.Strategy
import com.example.chat.domain.model.Account

class NicknameNotValidateStrategy(
    private val toast: DoToast,
    private val context: Context,
) : Strategy<Account> {
    private val toastLength = Toast.LENGTH_SHORT

    override suspend fun execute(item: Account) =
        toast.doToast(context, nicknameError, toastLength)

    private companion object {
        const val nicknameError = "Please Enter Nickname !"
    }
}