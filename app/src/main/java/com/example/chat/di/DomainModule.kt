package com.example.chat.di

import android.content.Context
import com.example.chat.core.DoToast
import com.example.chat.domain.interactor.ChatInteractor
import com.example.chat.domain.interactor.MainInteractor
import com.example.chat.domain.repositories.DeleteAllMessage
import com.example.chat.domain.repositories.Repository
import com.example.chat.domain.usecases.InsertUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideChatInteractor(
        repository: Repository,
        insert: InsertUseCase,
        deleteAll: DeleteAllMessage,
    ): ChatInteractor =
        ChatInteractor.Base(repository, insert, deleteAll)

    @Provides
    fun provideMainInteractor(
        toast: DoToast,
        context: Context
    ): MainInteractor = MainInteractor.Base(toast, context)
}