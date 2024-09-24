package com.meianoitedev.carshop.auth.presentation.register

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meianoitedev.carshop.auth.domain.use_case.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    private val _registerState = MutableStateFlow(RegisterState())
    val registerState: StateFlow<RegisterState> = _registerState.asStateFlow()

    private val _registerEvent = MutableSharedFlow<RegisterEvent>()
    val registerEvent: SharedFlow<RegisterEvent> = _registerEvent.asSharedFlow()

    fun updateEmail(newEmail: String) {
        _registerState.value = _registerState.value.copy(email = newEmail)
    }

    fun updatePassword(newPassword: String) {
        _registerState.value = _registerState.value.copy(password = newPassword)
    }

    fun registerUser(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                registerUseCase.invoke(email, password)
                _registerEvent.emit(RegisterEvent.Success)
            } catch (e: Exception) {
                _registerEvent.emit(RegisterEvent.Error(e.message.toString()))
                Log.e("RegisterViewModel", e.message, e)
            }
        }
    }
}