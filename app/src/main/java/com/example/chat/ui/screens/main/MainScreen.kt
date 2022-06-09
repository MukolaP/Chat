package com.example.chat.ui.screens.main

import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun MainScreen(
    navController: NavController, viewModel: MainViewModel = viewModel(),
) {
    var nickname: String by rememberSaveable { mutableStateOf("") }
    var email: String by rememberSaveable { mutableStateOf("") }

    Column {

        Spacer(modifier = Modifier.height(150.dp))

        TextField(
            value = nickname,
            onValueChange = {
                nickname = it
            },
            label = {
                Text("Enter your nickname")
            },
            modifier = Modifier
                .padding(start = 32.dp, end = 32.dp)
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.small.copy(
                bottomEnd = CornerSize(20),
                bottomStart = CornerSize(20)
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text("Enter your email address ")
            },
            modifier = Modifier
                .padding(start = 32.dp, end = 32.dp)
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.small.copy(
                bottomEnd = CornerSize(20),
                bottomStart = CornerSize(20)
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.weight(1F))

        Button(
            onClick = {
                viewModel.auditLoginButton(nickname, email, navController)
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp)

        ) {
            Text(text = "Log in")
        }
    }
}