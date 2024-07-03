package com.meianoitedev.carshop.presentation.auth.register.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meianoitedev.carshop.domain.usecase.auth.RegisterUseCase
import com.meianoitedev.carshop.presentation.auth.register.event.RegisterEvent
import com.meianoitedev.carshop.presentation.auth.register.state.RegisterState
import dagger.hilt.android.lifecycle.HiltViewModel
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

    private val _registerEvents = MutableSharedFlow<RegisterEvent>()
    val registerEvents: SharedFlow<RegisterEvent> = _registerEvents.asSharedFlow()

    fun updateEmail(newEmail: String) {
        _registerState.value = _registerState.value.copy(email = newEmail)
    }

    fun updatePassword(newPassword: String) {
        _registerState.value = _registerState.value.copy(password = newPassword)
    }

    fun register(email: String, password: String) {
        viewModelScope.launch {
            _registerState.value = _registerState.value.copy(isLoading = true)

            try {
                registerUseCase.invoke(email, password)
                _registerEvents.emit(RegisterEvent.Success)

            } catch (e: Exception) {
                _registerEvents.emit(RegisterEvent.Error("Erro ao registrar usuário"))
            } finally {
                _registerState.value = _registerState.value.copy(isLoading = false)
            }
        }
    }
}