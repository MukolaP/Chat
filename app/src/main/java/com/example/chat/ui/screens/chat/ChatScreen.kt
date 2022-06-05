package com.example.chat.ui.screens.chat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chat.R
import com.example.chat.domain.model.Message
import com.example.chat.ui.theme.AppTheme

@Composable
fun ChatScreen(
    viewModel: ChatViewModel = viewModel(),
) {
    val message = viewModel.message.observeAsState()
    val deleteIcon = R.drawable.ic_sharp_delete_sweep_24
    val openDialog = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            text = "Chat", modifier = Modifier
                                .weight(1F)
                                .padding(top = 10.dp)
                        )

                        IconButton(
                            onClick = {
                                openDialog.value = true
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = deleteIcon),
                                tint = Color.White,
                                contentDescription = "Send message"
                            )
                        }
                    }
                },
                backgroundColor = AppTheme.colors.secondaryBackground,
                contentColor = Color.White,
                elevation = 12.dp,
            )
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
                        MessageItem(item = item)
                    }
                }
            }

            DownLayerScreen(viewModel)
        }
    }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = { Text(text = "Action confirmation") },
            text = { Text("You really want to delete the entire chat ?") },
            buttons = {
                Row(
                    modifier = Modifier.padding(all = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = {
                            viewModel.deleteAll()
                            openDialog.value = false
                        }
                    ) {
                        Text(text = "Delete")
                    }

                    Spacer(modifier = Modifier.padding(start = 15.dp))

                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = {
                            openDialog.value = false
                        }
                    ) {
                        Text(text = "Cancel")
                    }
                }
            }
        )
    }
}

@Composable
fun MessageItem(item: Message) {

    Card(
        modifier = Modifier
            .height(75.dp)
            .padding(start = 28.dp, top = 16.dp),
        backgroundColor = AppTheme.colors.secondaryBackground,
        elevation = 8.dp,
        shape = MaterialTheme.shapes.small.copy(CornerSize(100))
    ) {
        Row {
            Text(text = checkNotNull(item.data))

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = checkNotNull(item.message),
                modifier = Modifier.padding(start = 8.dp, top = 18.dp, bottom = 5.dp)
            )
        }
    }
}

@Composable
fun DownLayerScreen(viewModel: ChatViewModel) {
    val sendIcon = R.drawable.ic_baseline_send_24
    var message: String by rememberSaveable { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
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
            )
        )

        IconButton(
            onClick = {
                viewModel.insert(Message(message = "$message    "))
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