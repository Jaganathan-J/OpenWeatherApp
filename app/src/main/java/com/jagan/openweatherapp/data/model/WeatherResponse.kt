package com.jagan.openweatherapp.data.model

data class WeatherResponse(
    val weather: List<Weather>,
    val main: Main,
    val name: String
)

data class Weather(
    val description: String,
    val icon: String
)

data class Main(
    var temp: Float,
    val humidity: Int
)