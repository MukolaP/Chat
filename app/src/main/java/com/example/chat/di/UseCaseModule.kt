package com.example.chat.di

import android.content.Context
import com.example.chat.core.DoToast
import com.example.chat.domain.repositories.InsertMessage
import com.example.chat.domain.usecases.InsertUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun bindInsertUseCase(context: Context, toast: DoToast, insert: InsertMessage):
            InsertUseCase = InsertUseCase(context, toast, insert)
}