package com.example.chat.ui.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chat.navigation.NavigationTree
import com.example.chat.ui.screens.chat.ChatScreen
import com.example.chat.ui.screens.chat.ChatViewModel
import com.example.chat.ui.screens.main.MainScreen

@Composable
fun ApplicationScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationTree.Main.name) {
        composable(NavigationTree.Main.name) { MainScreen(navController) }
        composable(NavigationTree.Chat.name) {
            val chatViewModel = hiltViewModel<ChatViewModel>()
            ChatScreen(viewModel = chatViewModel)
        }
    }
}