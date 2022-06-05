package com.example.chat.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.chat.navigation.NavigationTree

@Composable
fun MainScreen(navController: NavController) {
    LaunchedEffect(key1 = Unit, block = {
        navController.navigate(NavigationTree.Chat.name)
    })
}