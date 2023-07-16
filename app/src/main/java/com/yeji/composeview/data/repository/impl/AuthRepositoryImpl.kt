package com.yeji.composeview.data.repository.impl

import android.util.Log
import com.yeji.composeview.data.remote.api.AuthApi
import com.yeji.composeview.data.remote.model.SignInRequest
import com.yeji.composeview.data.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi
) : AuthRepository {

    override suspend fun signIn(request: SignInRequest) {
        val response = authApi.signIn("aun/p/authn/login", request)
        response.body()?.let {
            if (it.isSuccessful()) {
                Log.e("--------------", "ok")
            } else {
                Log.e("--------------", "no")
            }
        } ?: run {
            Log.e("--------------", "null")
        }
    }
}