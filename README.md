OpenWeatherApp 🌤️
A simple weather application built with Kotlin, Jetpack Compose, and Hilt for dependency injection. It fetches weather information using the OpenWeatherMap API based on user input for a city name or their current location.

Features
Display current weather details such as temperature, humidity, and weather description.
Fetch weather data for any city by typing the city name.
Use device's location to fetch weather data.
Jetpack Compose for UI, utilizing Material3 design.
Dependency Injection with Hilt.
Networking with Retrofit.
Image loading with Coil.
Tech Stack
Kotlin - Programming language.
Jetpack Compose - For building the UI.
Hilt - Dependency injection.
Retrofit - Networking library for making API calls.
Coil - Image loading library for Jetpack Compose.
OpenWeatherMap API - For fetching weather data.
Screenshots
City Weather Search	Location-Based Weather
Setup Instructions
Prerequisites
Android Studio (latest version).
An OpenWeatherMap API key, which you can obtain by signing up at OpenWeatherMap.
Getting Started
Clone the repository:

bash
Copy code
git clone https://github.com/jagan/openweatherapp.git
cd openweatherapp
Open the project in Android Studio.

Add your OpenWeatherMap API key:

Open the WeatherUseCase.kt file in com.jagan.openweatherapp.data.usecase.
Replace the apiKey variable with your own API key.
kotlin
Copy code
private val apiKey = "YOUR_API_KEY"
Sync the project with Gradle.

Run the app on an emulator or your device.

APIs Used
OpenWeatherMap API - Used to get weather data based on city names and geolocation.
Libraries Used
Jetpack Compose: For declarative UI.
Hilt: For dependency injection.
Retrofit: For HTTP client requests.
Coil: For loading images in Compose.
Gson: For parsing JSON responses.
Coroutines: For managing background tasks (async operations).
How to Use
City Weather Search: Enter the name of the city in the text field, and the app will display the current weather.
Location-Based Weather: Press the "Use My Location" button to allow the app to fetch the weather based on your current location (requires location permission).
Code Structure
MainActivity: The main entry point of the app, handles UI and interactions.
WeatherUseCase: Contains the business logic for interacting with the OpenWeatherMap API.
WeatherViewModel: ViewModel for managing the UI state.
WeatherService: Retrofit interface for API calls.
AppModule: Dagger Hilt module that provides dependencies like Retrofit and WeatherService.
Testing
To run unit tests:

bash
Copy code
./gradlew test
Future Enhancements
Add error handling for network issues.
Add more detailed weather information like forecasts.
Add dark mode support.
License
This project is licensed under the MIT License - see the LICENSE file for details.