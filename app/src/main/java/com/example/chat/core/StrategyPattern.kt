package com.example.chat.core

import android.content.Context

interface ChoiceStrategy<E, T : Strategy<E>> {

    fun setStrategy(strategy: T)

    suspend fun executeStrategy(item: E, context: Context): Any

    class Base<E, T : Strategy<E>> : ChoiceStrategy<E, T> {
        private lateinit var editNotes: T

        override fun setStrategy(strategy: T) {
            this.editNotes = strategy
        }

        override suspend fun executeStrategy(item: E, context: Context) =
            editNotes.execute(item)
    }
}

interface Strategy<E> {

    suspend fun execute(item: E): Any
}

