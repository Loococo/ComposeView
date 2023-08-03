package com.yeji.composeview.util.ext

import com.yeji.composeview.data.model.NetworkState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow

fun <T> safeFlow(block: suspend FlowCollector<NetworkState<T>>.() -> Unit): Flow<NetworkState<T>> = flow {
    try {
        block()
    } catch (e: Exception) {
        emit(NetworkState.Failure(e))
    }
}