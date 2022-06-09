package com.example.chat.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.chat.domain.interactor.MainInteractor
import com.example.chat.domain.model.Account
import com.example.chat.domain.model.Email
import com.example.chat.navigation.NavigationTree
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class MainViewModel @Inject constructor(
    private val interactor: MainInteractor,
    private val dispatcher: CoroutineContext
) : ViewModel() {

    fun auditLoginButton(message: String, email: String, navController: NavController) {
        viewModelScope.launch(dispatcher) {
            interactor.audit(Account(message, Email(value = email)))
        }
        if (interactor.auditNickname(message) && interactor.validateEmailAddress(Email(value = email)))
            navController.navigate(NavigationTree.Chat.name)
    }

}