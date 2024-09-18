package com.jagan.openweatherapp.data.usecase
import com.jagan.openweatherapp.data.api.WeatherService
import com.jagan.openweatherapp.data.model.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherUseCase @Inject constructor(
    private val weatherService: WeatherService
) {
    private val apiKey = "598641b99b0cd82c16dd593e27e22386"

    suspend fun getWeather(cityName: String): Result<WeatherResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = weatherService.getWeather(cityName, apiKey)
                response.main.temp = (response.main.temp - 273.15).toFloat()
                Result.success(response)
            } catch (e: Exception) {
                Result.failure(e) // Wrap the exception in a failure result
            }
        }
    }

    suspend fun getWeatherByLocation(latitude: Double, longitude: Double): Result<WeatherResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = weatherService.getWeatherByLocation(latitude, longitude, apiKey)
                response.main.temp = (response.main.temp - 273.15).toFloat()
                Result.success(response)
            } catch (e: Exception) {
                Result.failure(e)  // Wrap the exception in a failure result
            }
        }
    }
}
