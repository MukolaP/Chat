package com.example.chat.domain.interactor.audit

import android.content.Context
import android.widget.Toast
import com.example.chat.core.DoToast
import com.example.chat.core.Strategy
import com.example.chat.domain.model.Account

class EmailNotValidateStrategy(
    private val toast: DoToast,
    private val context: Context,
) : Strategy<Account> {
    private val toastLength = Toast.LENGTH_SHORT

    override suspend fun execute(item: Account) =
        toast.doToast(context, emailError, toastLength)

    private companion object {
        const val emailError = "Invalid Email Address"
    }
}