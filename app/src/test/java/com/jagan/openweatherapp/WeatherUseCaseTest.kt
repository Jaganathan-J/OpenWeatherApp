package com.jagan.openweatherapp

import com.jagan.openweatherapp.data.api.WeatherService
import com.jagan.openweatherapp.data.model.Main
import com.jagan.openweatherapp.data.model.Weather
import com.jagan.openweatherapp.data.model.WeatherResponse
import com.jagan.openweatherapp.data.usecase.WeatherUseCase
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class WeatherUseCaseTest {

    private lateinit var weatherService: WeatherService
    private lateinit var weatherUseCase: WeatherUseCase

    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        weatherService = Mockito.mock(WeatherService::class.java)
        weatherUseCase = WeatherUseCase(weatherService)
        kotlinx.coroutines.Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        kotlinx.coroutines.Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `test getWeather returns success with temperature in Celsius`(): Unit = runBlocking {
        // Mock data for a successful response
        val mockWeatherResponse = WeatherResponse(
            main = Main(temp = 300.0f, humidity = 80),
            weather = listOf(Weather(description = "Clear sky", icon = "01d")),
            name = "London"
        )

        // Mock the API call response
        whenever(weatherService.getWeather("London", "598641b99b0cd82c16dd593e27e22386"))
            .thenReturn(mockWeatherResponse)

        // Call the use case method
        val result = weatherUseCase.getWeather("London")

        // Assert success
        assertTrue(result.isSuccess)

        // Extract the result
        val weatherData = result.getOrNull()
        
        // Make sure temperature conversion works correctly
        val temperatureInCelsius = weatherData?.main?.temp

        println("Temperature in Celsius: $temperatureInCelsius")
        // Perform the assertion
        temperatureInCelsius?.toDouble()?.let { assertEquals(26.85, it, 0.01) }
    }
    @Test
    fun `test getWeather returns failure on exception`() = runBlocking {
        // Mock an exception during the API call
        whenever(weatherService.getWeather("London", "598641b99b0cd82c16dd593e27e22386"))
            .thenThrow(RuntimeException("API Error"))

        // Call the use case method
        val result = weatherUseCase.getWeather("London")

        // Assert failure
        assertTrue(result.isFailure)
    }
}