package com.example.chat.app

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.HiltAndroidApp

val isLight = mutableStateOf(true)

@HiltAndroidApp
class App : Application()

