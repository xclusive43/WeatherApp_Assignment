# WeatherApp

WeatherApp is an Android application that provides real-time weather updates for specified cities using the OpenWeatherMap API.

## Key Features

- Retrieve current weather data for a given city.
- Display various weather parameters including temperature, humidity, and wind speed.
- Save the latest weather data in a local Room database.
- Show the last saved weather data on app launch until new data is fetched.

## Technology Stack

- **Android Jetpack Components**:
  - ViewModel
  - LiveData
  - Room Database
- **Networking**:
  - Retrofit for API calls
  - Gson for JSON parsing

## Setup Instructions

### Requirements

- Android Studio
- API key from [OpenWeatherMap](https://openweathermap.org/api)

### Steps to Setup

1. Clone the repository:

```bash
[git clone https://github.com/your-username/WeatherApp.git](https://github.com/xclusive43/WeatherApp_Assignment.git)
```
2. Open the project with Android Studio.
3. Add your API key:

### Create a local.properties file in the project root.
Include your API key:
properties
Copy code
```bash
weather_api_key=your_api_key_here
```

4. Adding Dependencies
Ensure these dependencies are included in your build.gradle:

### gradle Copy code
```gradle
dependencies {
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("androidx.room:room-runtime:2.4.0")
    annotationProcessor("androidx.room:room-compiler:2.4.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    annotationProcessor("androidx.lifecycle:lifecycle-compiler:2.2.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0" )
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")
}
```
5. Usage Guide
### Fetching Weather Data
    a. Enter the city name in the input field.
    b. Click the "Fetch Weather" button.
    c. The app will display the current weather data.
    d. Viewing Saved Weather Data
    e. The app will display the most recently saved weather data when launched, until new data is fetched.

