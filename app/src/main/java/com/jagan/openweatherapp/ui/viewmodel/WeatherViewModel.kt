package com.jagan.openweatherapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jagan.openweatherapp.data.model.WeatherResponse
import com.jagan.openweatherapp.data.usecase.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val useCase: WeatherUseCase
) : ViewModel() {

    private val _weatherData = MutableLiveData<WeatherResponse?>()
    val weatherData: LiveData<WeatherResponse?> = _weatherData

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    fun getWeather(cityName: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val result = useCase.getWeather(cityName)
                result.fold(
                    onSuccess = { weather ->
                        _weatherData.postValue(weather)
                        _errorMessage.postValue(null)
                    },
                    onFailure = { throwable ->
                        _errorMessage.postValue(throwable.message ?: "Unknown error")
                    }
                )
            } catch (e: Exception) {
                _errorMessage.postValue("Error fetching weather data")
            } finally {
                _isLoading.postValue(false)
            }
        }
    }

    fun getWeatherByLocation(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val result = useCase.getWeatherByLocation(latitude, longitude)
                result.fold(
                    onSuccess = { weather ->
                        _weatherData.postValue(weather)
                        _errorMessage.postValue(null)
                    },
                    onFailure = { throwable ->
                        _errorMessage.postValue(throwable.message ?: "Unknown error")
                    }
                )
            } catch (e: Exception) {
                _errorMessage.postValue("Error fetching weather data for location")
            } finally {
                _isLoading.postValue(false)
            }
        }
    }
}
