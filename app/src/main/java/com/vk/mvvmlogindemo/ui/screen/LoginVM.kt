package com.vk.mvvmlogindemo.ui.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginVM : ViewModel() {
    var enterEmail = MutableLiveData("")
    var enterPassword = MutableLiveData("")

    private val _message = MutableLiveData<String?>()
    val message: LiveData<String?> = _message

    private val _isSuccess = MutableLiveData<Boolean?>()
    val isSuccess: LiveData<Boolean?> = _isSuccess

    fun onEmailChange(value: String) {
        enterEmail.value = value
    }

    fun onPasswordChange(value: String) {
        enterPassword.value = value
    }

    fun login() {
        val email = enterEmail.value.orEmpty()
        val password = enterPassword.value.orEmpty()

        if(email.isBlank() || password.isBlank()) {
            _message.value = "Email and Password cannot be empty"
            _isSuccess.value = false
            return
        } else {
            _message.value = "Login Successful"
            _isSuccess.value = true
        }
    }
}