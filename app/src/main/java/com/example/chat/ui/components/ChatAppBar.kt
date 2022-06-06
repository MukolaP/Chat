package com.example.chat.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.chat.R
import com.example.chat.app.isLight
import com.example.chat.ui.screens.chat.ChatViewModel
import com.example.chat.ui.theme.AppTheme

@Composable
fun ChatTopBar(viewModel: ChatViewModel) {
    val deleteIcon = R.drawable.ic_sharp_delete_sweep_24
    val lightTheme = R.drawable.ic_baseline_brightness_1_24
    val darkTheme = R.drawable.ic_baseline_brightness_2_24

    val themeIcon = remember { mutableStateOf(lightTheme) }
    val openDialog = remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Row {
                Text(
                    text = "Chat",
                    modifier = Modifier
                        .weight(1F)
                        .padding(top = 10.dp)
                )

                IconButton(
                    onClick = {
                        isLight.value = !isLight.value
                        themeIcon.value =
                            viewModel.changeUse(themeIcon.value, darkTheme, lightTheme)
                    }
                ) {
                    Icon(
                        painter = painterResource(id = themeIcon.value),
                        tint = Color.White,
                        contentDescription = "Change theme"
                    )
                }

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