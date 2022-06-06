package com.example.chat.ui.screens.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chat.app.user
import com.example.chat.domain.model.Message
import com.example.chat.ui.components.ChatDownLayerScreen
import com.example.chat.ui.components.ChatTopBar
import com.example.chat.ui.components.MessageItem
import com.example.chat.ui.theme.AppTheme

@Composable
fun ChatScreen(
    viewModel: ChatViewModel = viewModel(),
) {
    val message: State<List<Message>?> = viewModel.message.observeAsState()

    val colorUserOne = AppTheme.colors.secondaryBackground
    val colorTwoUser = AppTheme.colors.colorSecondaryUser

    val textOneColor = Color.White
    val textTwoColor = Color.Black

    Scaffold(
        topBar = {
            ChatTopBar(viewModel = viewModel)
        },
    ) {
        Column {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F),
                horizontalAlignment = viewModel.changeListAlignment(user.value),
            ) {
                item {
                    message.value?.map { item ->
                        MessageItem(
                            item = item,
                            viewModel.changeUserColor(user.value, colorUserOne, colorTwoUser),
                            viewModel.changeUserColor(user.value, textOneColor, textTwoColor)
                        )
                    }
                }
            }

            ChatDownLayerScreen(viewModel)
        }
    }
}
