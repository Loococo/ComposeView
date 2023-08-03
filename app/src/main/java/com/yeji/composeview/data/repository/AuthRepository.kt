package com.yeji.composeview.data.repository

import com.yeji.composeview.data.model.NetworkState
import com.yeji.composeview.data.source.remote.model.SignInRequest
import com.yeji.composeview.data.source.remote.model.SignInResponse
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun signIn(request: SignInRequest): Flow<NetworkState<SignInResponse>>
}