package com.example.chat.ui.screens.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chat.ui.components.ChatDownLayerScreen
import com.example.chat.ui.components.ChatTopBar
import com.example.chat.ui.components.MessageItem
import com.example.chat.ui.theme.AppTheme

@Composable
fun ChatScreen(
    viewModel: ChatViewModel = viewModel(),
) {
    val message = viewModel.message.observeAsState()

    Scaffold(
        topBar = {
            ChatTopBar(viewModel = viewModel)
        },
    ) {
        Column {

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                item {
                    message.value?.map { item ->
                        MessageItem(item = item, AppTheme.colors.secondaryBackground)
                    }
                }
            }

            ChatDownLayerScreen(viewModel)
        }
    }
}
