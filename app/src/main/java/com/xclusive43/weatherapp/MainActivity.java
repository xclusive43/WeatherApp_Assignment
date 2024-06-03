package com.xclusive43.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.xclusive43.weatherapp.Model.WeatherResponseModel;
import com.xclusive43.weatherapp.Retrofit.RetrofitClient;
import com.xclusive43.weatherapp.Retrofit.WeatherService;
import com.xclusive43.weatherapp.RoomDB.ViewModel;
import com.xclusive43.weatherapp.RoomDB.WeatherData;
import com.xclusive43.weatherapp.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private final String apiKey = "f40e87a6441a691b9423e807ac4770ac";
    private ActivityMainBinding binding;
    private  ViewModel weatherViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        weatherViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(ViewModel.class);

        //Get Saved Weather Data
        getSavedWeatherData();

        binding.dashboardWeather.setVisibility(View.VISIBLE);
        binding.buttonGetWeather.setOnClickListener(v -> {
            String city = binding.editTextCity.getText().toString();
            if (!city.isEmpty()) {
                getWeatherDataFromRetrofit(city,apiKey);
            } else {
                Toast.makeText(MainActivity.this, "Please enter a city name", Toast.LENGTH_SHORT).show();
            }
        });

        //validation for editTextCity
        binding.editTextCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validateCityName(s.toString());
            }

            private void validateCityName(String cityName) {
                if (cityName.isEmpty()) {
                    binding.editTextCity.setError("City name cannot be empty");
                    binding.buttonGetWeather.setEnabled(false);
                } else if (cityName.length() < 2 || cityName.length() > 50) {
                    binding.editTextCity.setError("City name must be between 2 and 50 characters");
                    binding.buttonGetWeather.setEnabled(false);
                }else if (!cityName.matches("[a-zA-Z]+")) {
                    binding.editTextCity.setError("City name must contain only letters");
                    binding.buttonGetWeather.setEnabled(false);
                }else {
                    binding.buttonGetWeather.setEnabled(true);
                }
            }
        });
    }

    private void getWeatherDataFromRetrofit(String cityName, String apiKey) {
            binding.progressBar.setVisibility(View.VISIBLE);
            WeatherService weatherService = RetrofitClient.getClient("https://api.openweathermap.org/data/2.5/").create(WeatherService.class);
            Call<WeatherResponseModel> call = weatherService.getCurrentWeather(cityName, apiKey, "metric");

            call.enqueue(new Callback<WeatherResponseModel>() {
                @Override
                public void onResponse(Call<WeatherResponseModel> call, Response<WeatherResponseModel> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        WeatherResponseModel weatherResponse = response.body();
                        weatherViewModel.deleteAllWeatherData();
                        Log.d("DATA", weatherResponse.toString());
                        DateTimeMapper dateTimeMapper = new DateTimeMapper();
                        binding.cityNameEntered.setText(weatherResponse.name);

                        String currentDate = dateTimeMapper.getFormattedDatTime(weatherResponse.dt);
                        binding.currentDate.setText(currentDate);
                        binding.temperatureCelsius.setText(String.valueOf( weatherResponse.main.temp).concat(getResources().getString(R.string.celsius)));
                        String feelsLike = "Now it feels like "+String.valueOf(weatherResponse.main.feelsLike).concat(getResources().getString(R.string.celsius))+", actually its "+ String.valueOf( weatherResponse.main.temp).concat(getResources().getString(R.string.celsius));
                        binding.dailySummaryDesc.setText(feelsLike);

                        binding.title1.setText(String.valueOf(weatherResponse.wind.speed).concat("km/h"));
                        binding.title2.setText(String.valueOf(weatherResponse.main.humidity).concat("%"));
                        VisibilityConverter visibilityConverter = new VisibilityConverter();

                        double visibility = visibilityConverter.metersToKilometers(weatherResponse.visibility);
                        binding.title3.setText(String.valueOf(visibility).concat("km"));
                        binding.progressBar.setVisibility(View.INVISIBLE);

                        //save to Room DB
                        saveWeatherData(weatherResponse, currentDate, visibility);
                    } else {
                        binding.progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(MainActivity.this, "City not found", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<WeatherResponseModel> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Error fetching weather data", Toast.LENGTH_SHORT).show();
                }
            });

    }


    private void saveWeatherData(WeatherResponseModel weatherResponse, String currentDate, double visibility) {

        WeatherData weatherData = new WeatherData();
        weatherData.cityName = weatherResponse.name;
        weatherData.currentDate = currentDate;
        weatherData.temperature = weatherResponse.main.temp;
        weatherData.feelsLike = weatherResponse.main.feelsLike;
        weatherData.windSpeed = weatherResponse.wind.speed;
        weatherData.humid = weatherResponse.main.humidity;
        weatherData.visibility = visibility;
        weatherViewModel.insert(weatherData);
    }

    private void getSavedWeatherData() {

        weatherViewModel.getWeatherData().observe(this, weatherData -> {
            // Update UI with saved weather data
            if (weatherData != null) {
                binding.cityNameEntered.setText(weatherData.cityName);
                binding.currentDate.setText(weatherData.currentDate);
                binding.temperatureCelsius.setText(String.valueOf( weatherData.temperature).concat(getResources().getString(R.string.celsius)));
                String feelsLike = "Now it feels like "+String.valueOf(weatherData.feelsLike).concat(getResources().getString(R.string.celsius))+", actually its "+ String.valueOf( weatherData.temperature).concat(getResources().getString(R.string.celsius));
                binding.dailySummaryDesc.setText(feelsLike);

                binding.title1.setText(String.valueOf(weatherData.windSpeed).concat("km/h"));
                binding.title2.setText(String.valueOf(weatherData.humid).concat("%"));
                VisibilityConverter visibilityConverter = new VisibilityConverter();

                double visibility = visibilityConverter.metersToKilometers(weatherData.visibility);
                binding.title3.setText(String.valueOf(visibility).concat("km"));
                binding.progressBar.setVisibility(View.INVISIBLE);
                // Set other views with weather data
            }
        });
    }
}