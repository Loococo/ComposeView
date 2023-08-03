package com.yeji.composeview.util.ext

import com.yeji.composeview.data.model.NetworkState

fun <T> NetworkState<T>.onData(result: NetworkState.Data<T>.() -> Unit): NetworkState<T> {
    if (this is NetworkState.Data) result(this)
    return this
}

fun <T> NetworkState<T>.onFailure(result: NetworkState.Failure<T>.() -> Unit): NetworkState<T> {
    if (this is NetworkState.Failure) result(this)
    return this
}

fun <T> NetworkState<T>.onMessage(result: NetworkState.Message<T>.() -> Unit): NetworkState<T> {
    if (this is NetworkState.Message) result(this)
    return this
}