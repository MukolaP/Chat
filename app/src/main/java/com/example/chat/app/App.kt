package com.example.chat.app

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.HiltAndroidApp

val isLight = mutableStateOf(true)
val user = mutableStateOf(false)

@HiltAndroidApp
class App : Application()

