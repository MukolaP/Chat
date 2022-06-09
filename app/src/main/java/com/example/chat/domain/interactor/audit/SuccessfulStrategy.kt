package com.example.chat.domain.interactor.audit

import com.example.chat.app.nickname
import com.example.chat.core.Strategy
import com.example.chat.domain.model.Account

class SuccessfulStrategy : Strategy<Account> {
    override suspend fun execute(item: Account) {
        nickname = item.nickname
    }
}