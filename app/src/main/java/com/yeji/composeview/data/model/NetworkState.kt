package com.yeji.composeview.data.model

sealed class NetworkState<out T> {
    class Data<T> constructor(val data: T) : NetworkState<T>()
    class Message<T> constructor(val message: String) : NetworkState<T>()
    class Failure<T> constructor(val exception: Throwable) : NetworkState<T>()
}