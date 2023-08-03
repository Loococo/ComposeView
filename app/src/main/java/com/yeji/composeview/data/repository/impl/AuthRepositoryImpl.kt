package com.yeji.composeview.data.repository.impl

import com.yeji.composeview.data.source.remote.api.AuthApi
import com.yeji.composeview.data.model.NetworkState
import com.yeji.composeview.data.source.remote.model.SignInRequest
import com.yeji.composeview.data.source.remote.model.SignInResponse
import com.yeji.composeview.data.repository.AuthRepository
import com.yeji.composeview.util.ext.safeFlow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi
) : AuthRepository {

    override suspend fun signIn(request: SignInRequest): Flow<NetworkState<SignInResponse>> =
        safeFlow {
            val response = authApi.signIn("aun/p/authn/login", request)
            response.body()?.let {
                if (it.isSuccessful()) {
                    emit(NetworkState.Data(it.data!!))
                } else {
                    emit(NetworkState.Message(it.msg!!))
                }
            } ?: run {
                emit(NetworkState.Message("실패"))
            }
        }
}