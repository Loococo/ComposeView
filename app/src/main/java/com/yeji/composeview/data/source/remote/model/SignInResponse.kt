package com.yeji.composeview.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class SignInResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("email")
    val email: String,
    @SerializedName("username")
    val username: String
)