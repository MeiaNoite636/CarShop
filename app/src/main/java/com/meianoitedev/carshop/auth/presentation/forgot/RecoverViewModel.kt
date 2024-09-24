package com.meianoitedev.carshop.auth.presentation.forgot

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meianoitedev.carshop.auth.domain.use_case.RecoverUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class RecoverViewModel @Inject constructor(
    private val recoverUseCase: RecoverUseCase
) : ViewModel() {

    private val _recoverState = MutableStateFlow(RecoverState())
    val recoverState: StateFlow<RecoverState> = _recoverState.asStateFlow()

    private val _forgotEvent = MutableSharedFlow<ForgotEvent>()
    val forgotEvent: SharedFlow<ForgotEvent> = _forgotEvent.asSharedFlow()

    fun updateEmail(newEmail: String) {
        _recoverState.value = _recoverState.value.copy(email = newEmail)
    }

    fun recoverPassword(email: String) {
        viewModelScope.launch {
            try {
                recoverUseCase.invoke(email)
                _forgotEvent.emit(ForgotEvent.Success)
            } catch (e: Exception) {
                _forgotEvent.emit(ForgotEvent.Error(message = e.message.toString()))
            } catch (ioException: IOException) {
                _forgotEvent.emit(ForgotEvent.Error(message = ioException.message.toString()))
            }
        }
    }

}