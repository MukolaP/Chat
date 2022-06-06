package com.example.chat.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.chat.R
import com.example.chat.domain.model.Message
import com.example.chat.ui.screens.chat.ChatViewModel
import com.example.chat.ui.theme.AppTheme

@Composable
fun ChatDownLayerScreen(viewModel: ChatViewModel) {
    val sendIcon = R.drawable.ic_baseline_send_24
    var message: String by rememberSaveable { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 0.dp, end = 10.dp, bottom = 10.dp)
    ) {
        TextField(
            value = message,
            onValueChange = {
                message = it
            },
            label = {
                Text("Your message")
            },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = MaterialTheme.shapes.small.copy(
                bottomEnd = CornerSize(100),
                bottomStart = CornerSize(100)
            ),
            singleLine = true
        )

        IconButton(
            onClick = {
                viewModel.insert(Message(data = viewModel.date(), message = "$message       "))
                message = ""
            }
        ) {
            Icon(
                painter = painterResource(id = sendIcon),
                tint = AppTheme.colors.primaryTintColor,
                contentDescription = "Send message"
            )
        }
    }
}