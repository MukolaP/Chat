package com.example.chat.di

import com.example.chat.data.database.AppDatabase
import com.example.chat.data.repository.BaseRepository
import com.example.chat.data.repository.DeleteAllMessageImpl
import com.example.chat.data.repository.InsertMessageImpl
import com.example.chat.data.repository.UpdateMessageImpl
import com.example.chat.domain.repositories.DeleteAllMessage
import com.example.chat.domain.repositories.InsertMessage
import com.example.chat.domain.repositories.Repository
import com.example.chat.domain.repositories.UpdateMessage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(database: AppDatabase): Repository =
        BaseRepository(database.notesDao())

    @Singleton
    @Provides
    fun provideInsertMessage(database: AppDatabase): InsertMessage =
        InsertMessageImpl(database.notesDao())

    @Singleton
    @Provides
    fun provideUpdateMessage(database: AppDatabase): UpdateMessage =
        UpdateMessageImpl(database.notesDao())

    @Singleton
    @Provides
    fun provideDeleteAllMessage(database: AppDatabase): DeleteAllMessage =
        DeleteAllMessageImpl(database.notesDao())
}