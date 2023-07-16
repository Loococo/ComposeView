package com.yeji.composeview.data.remote.model

import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @SerializedName("email")
    var email: String = ""
)