package com.meianoitedev.carshop.home_feature.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meianoitedev.carshop.home_feature.domain.use_case.GetCarsUseCase
import com.meianoitedev.carshop.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCarsUseCase: GetCarsUseCase
) : ViewModel() {

    private val _homeState = MutableStateFlow<Resource<HomeState>>(Resource.Loading)
    val homeState: StateFlow<Resource<HomeState>> = _homeState.asStateFlow()

    fun fetchCars() {
        viewModelScope.launch(Dispatchers.IO){
            try {
                val cars = getCarsUseCase.invoke()
                _homeState.value = Resource.Success(HomeState(cars))
            } catch (e: Exception) {
                Log.e("HomeViewModel", "Erro ao buscar carros", e)
                _homeState.value = Resource.Error(message = "Erro ao buscar carros", exception = e)
            }
        }
    }
}