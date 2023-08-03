package com.yeji.composeview.data.model

sealed class SignInState {
    object Init : SignInState()
    object Loading : SignInState()
}