package com.xclusive43.weatherapp.RoomDB;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ViewModel extends AndroidViewModel {
    WeatherDataRepository repository;
    private LiveData<WeatherData> weatherData;
    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new WeatherDataRepository(application);
        weatherData = repository.getWeatherData();
    }


    public LiveData<WeatherData> getWeatherData() {
        return weatherData;
    }

    public void insert(WeatherData data) {
        Log.d("INSERT", String.valueOf(data.visibility));
        repository.insert(data);
    }

    public void deleteAllWeatherData() {
        repository.deleteAll();
    }
}
