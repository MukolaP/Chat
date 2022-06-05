package com.example.chat.core

interface Mapper<From, To> {

    fun map(data: From): To

    interface Unit<T> : Mapper<T, kotlin.Unit>
}