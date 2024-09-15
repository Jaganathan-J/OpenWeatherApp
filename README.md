OpenWeatherApp 🌤️
Android Weather Forecast App implemented in MVVM Architecture using Kotlin that enables users to have instant access to weather data based on city name or current location.

Download
<a href='https://play.google.com/store/apps/details?id=com.jagan.openweatherapp'><img alt='Get it on Google Play' src='https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Google_Play_Store_badge_EN.svg/512px-Google_Play_Store_badge_EN.svg.png' width="20%" height="60"/></a>

Features:
Simple and user-friendly UI.
Get current weather data by entering the city name.
Fetch current weather based on device location (latitude and longitude).
Weather information includes temperature, humidity, and weather description.
Real-time weather data updates.
Support for both Celsius and Fahrenheit temperature units.
Modern design using Jetpack Compose and Material 3.
Tech Stack:
Jetpack Compose: For building declarative UI.
Hilt: For dependency injection.
Retrofit: For making API calls.
Coil: For image loading.
Kotlin Coroutines: For managing background tasks.
Libraries included:
Retrofit for network calls.
Gson for JSON parsing.
Jetpack Compose for UI.
Dagger Hilt for dependency injection.
Coil for image loading in Compose.
Note: You will need your own OpenWeatherMap API key. After obtaining it, place the key in the WeatherUseCase.kt file under com.jagan.openweatherapp.data.usecase:

kotlin
Copy code
private val apiKey = "YOUR_API_KEY"
Screenshots
<img src="https://via.placeholder.com/250x500.png?text=City+Weather+Search" width="250">	<img src="https://via.placeholder.com/250x500.png?text=Location+Weather" width="250">	<img src="https://via.placeholder.com/250x500.png?text=Weather+Details" width="250">
Project Preview: YouTube.
