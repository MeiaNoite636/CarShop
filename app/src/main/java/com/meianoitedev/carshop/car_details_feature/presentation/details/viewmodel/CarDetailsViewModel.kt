package com.meianoitedev.carshop.car_details_feature.presentation.details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meianoitedev.carshop.car_details_feature.domain.usecase.GetCarDetailsUseCase
import com.meianoitedev.carshop.car_details_feature.presentation.details.event.CarDetailsEvent
import com.meianoitedev.carshop.car_details_feature.presentation.details.state.CarDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarDetailsViewModel @Inject constructor(
    private val getCarDetailsUseCase: GetCarDetailsUseCase
) : ViewModel() {

    private val _carDetailsState = MutableStateFlow(CarDetailsState())
    val carDetailsState: Flow<CarDetailsState> = _carDetailsState.asStateFlow()

    private val _carDetailsEvent = MutableSharedFlow<CarDetailsEvent>()
    val carDetailsEvent: SharedFlow<CarDetailsEvent> = _carDetailsEvent.asSharedFlow()

    fun getCarDetails(carId: Int){
        viewModelScope.launch {
            try {
                val carDetailsResult = getCarDetailsUseCase.invoke(carId)
                _carDetailsState.value = _carDetailsState.value.copy(
                    year = carDetailsResult.year,
                    fuel = carDetailsResult.fuel,
                    id = carDetailsResult.id,
                    modelName = carDetailsResult.modelName,
                    price = carDetailsResult.price,
                    doorsNumber = carDetailsResult.doorsNumber,
                    registerTimestamp = carDetailsResult.registerTimestamp,
                    color = carDetailsResult.color
                )

                _carDetailsEvent.emit(CarDetailsEvent.Success)
            }catch (e: Exception){
                _carDetailsEvent.emit(CarDetailsEvent.Error(message = e.message.toString()))
            }
        }
    }

}
