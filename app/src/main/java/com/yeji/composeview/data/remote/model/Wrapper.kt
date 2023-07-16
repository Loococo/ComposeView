package com.yeji.composeview.data.remote.model

import com.google.gson.annotations.SerializedName

data class Wrapper<T>(
    @field:SerializedName("data")
    val data: T? = null,

    @field:SerializedName("msgCode")
    val msgCode: String? = null
) {
    fun isSuccessful(): Boolean {
        return msgCode == "ok"
    }
}
