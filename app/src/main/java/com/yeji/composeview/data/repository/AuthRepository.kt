package com.yeji.composeview.data.repository

import com.yeji.composeview.data.remote.model.SignInRequest

interface AuthRepository {
    suspend fun signIn(request: SignInRequest)
}