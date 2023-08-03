package com.yeji.composeview.data.source.remote.api

import com.yeji.composeview.data.source.remote.model.SignInRequest
import com.yeji.composeview.data.source.remote.model.SignInResponse
import com.yeji.composeview.data.model.Wrapper
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthApi {

    @POST("{url}")
    suspend fun signIn(
        @Path(value = "url", encoded = true) url: String,
        @Body data: SignInRequest
    ): Response<Wrapper<SignInResponse>>
}