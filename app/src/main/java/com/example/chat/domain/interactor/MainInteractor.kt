package com.example.chat.domain.interactor

import android.content.Context
import android.util.Patterns
import com.example.chat.core.ChoiceStrategy
import com.example.chat.core.DoToast
import com.example.chat.core.Strategy
import com.example.chat.domain.interactor.audit.EmailNotValidateStrategy
import com.example.chat.domain.interactor.audit.NicknameNotValidateStrategy
import com.example.chat.domain.interactor.audit.SuccessfulStrategy
import com.example.chat.domain.interactor.audit.UnknownError
import com.example.chat.domain.model.Account
import com.example.chat.domain.model.Email
import javax.inject.Inject

interface MainInteractor {

    fun auditNickname(message: String): Boolean

    fun validateEmailAddress(email: Email): Boolean

    suspend fun audit(account: Account): Any

    class Base @Inject constructor(
        private val toast: DoToast,
        private val context: Context,
    ) : MainInteractor {
        private val strategy = ChoiceStrategy.Base<Account, Strategy<Account>>()

        override fun auditNickname(message: String): Boolean = message.isNotEmpty()

        override fun validateEmailAddress(email: Email): Boolean =
            email.value.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email.value).matches()

        override suspend fun audit(account: Account): Any {
            if (auditNickname(account.nickname) && validateEmailAddress(account.email)) strategy.setStrategy(
                SuccessfulStrategy()
            )
            else if (!auditNickname(account.nickname)) strategy.setStrategy(
                NicknameNotValidateStrategy(toast, context)
            )
            else if (!validateEmailAddress(account.email)) strategy.setStrategy(
                EmailNotValidateStrategy(toast, context)
            )
            else strategy.setStrategy(UnknownError(toast, context))

            return strategy.executeStrategy(Account(account.nickname, account.email), context)
        }
    }
}
