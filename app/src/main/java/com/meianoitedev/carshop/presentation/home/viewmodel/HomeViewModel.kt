package com.meianoitedev.carshop.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meianoitedev.carshop.domain.usecase.car.GetCarUseCase
import com.meianoitedev.carshop.presentation.home.state.HomeState
import com.meianoitedev.carshop.presentation.uistate.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCarUseCase: GetCarUseCase
) : ViewModel() {

    private val _homeState = MutableStateFlow<UiState<HomeState>>(UiState.Loading)
    val homeState: StateFlow<UiState<HomeState>> = _homeState.asStateFlow()

    fun fetchCars() {
        viewModelScope.launch {
            _homeState.value = UiState.Loading
            try {
                val cars = getCarUseCase.invoke()
                _homeState.value = UiState.Success(HomeState(cars))
            } catch (e: Exception) {
                _homeState.value = UiState.Error(message = "Erro ao buscar carros", exception = e)
            }
        }
    }
}