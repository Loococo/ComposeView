package com.yeji.composeview.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeji.composeview.data.model.SignInState
import com.yeji.composeview.data.source.remote.model.SignInRequest
import com.yeji.composeview.util.ext.onData
import com.yeji.composeview.util.ext.onFailure
import com.yeji.composeview.util.ext.onMessage
import com.yeji.composeview.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val authRepository: AuthRepository) :
    ViewModel() {

    private val _emailLiveData = MutableLiveData<String>()

    private val _progressLiveData = MutableLiveData<Boolean>()
    val progressLiveData: LiveData<Boolean> = _progressLiveData


    private val _signInFlow = MutableStateFlow<SignInState>(SignInState.Init)
    val signInFlow: StateFlow<SignInState> = _signInFlow

    fun signIn(email: String) {
        viewModelScope.launch {
            val request = SignInRequest(email)
            authRepository.signIn(request)
                .onStart {
                    _progressLiveData.value = true
                }
                .collect {
                    it
                        .onData {
                            Log.e("---------","onData--$data")
                        }
                        .onMessage {
                            Log.e("---------","onMessage--$message")
                        }
                        .onFailure {
                            Log.e("---------","onFailure--$exception")
                        }
                    _progressLiveData.value = false
                }
        }
    }

    fun email(value: String) {
        _emailLiveData.value = value
    }

    fun email(): String = _emailLiveData.value ?: ""
}