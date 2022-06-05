package com.example.chat.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.chat.ui.screens.ApplicationScreen
import com.example.chat.ui.theme.ChatTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ThemeInitialise(isLight.value)
        }
    }
}

@Composable
fun ThemeInitialise(theme: Boolean) {
    ChatTheme(theme) {
        ApplicationScreen()
    }
}