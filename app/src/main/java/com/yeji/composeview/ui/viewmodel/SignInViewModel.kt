package com.yeji.composeview.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeji.composeview.data.remote.model.SignInRequest
import com.yeji.composeview.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val authRepository: AuthRepository) :
    ViewModel() {

    private val _emailLiveData = MutableLiveData<String>()
    val emailLiveData: LiveData<String> = _emailLiveData

    fun signIn(email: String) {
        viewModelScope.launch {
            val request = SignInRequest(email)
            authRepository.signIn(request)
        }
    }

    fun email(value: String) {
        _emailLiveData.value = value
    }

    fun email(): String = _emailLiveData.value ?: ""
}