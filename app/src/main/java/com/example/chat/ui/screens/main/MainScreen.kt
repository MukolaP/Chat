package com.example.chat.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun MainScreen(
    navController: NavController, viewModel: MainViewModel = viewModel(),
) {
    var message: String by rememberSaveable { mutableStateOf("") }

    Column {

        Spacer(modifier = Modifier.weight(1F))

        TextField(
            value = message,
            onValueChange = {
                message = it
            },
            label = {
                Text("Enter your nickname")
            },
            modifier = Modifier
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.small.copy(
                bottomEnd = CornerSize(5),
                bottomStart = CornerSize(5)
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.weight(1F))

        Button(
            onClick = {
                viewModel.auditLoginButton(message, navController)
            }, modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Log in")
        }
    }
}