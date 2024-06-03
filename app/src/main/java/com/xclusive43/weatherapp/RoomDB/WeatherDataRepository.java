package com.xclusive43.weatherapp.RoomDB;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.xclusive43.weatherapp.Model.WeatherResponseModel;
import com.xclusive43.weatherapp.Retrofit.RetrofitClient;
import com.xclusive43.weatherapp.Retrofit.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherDataRepository {
    private WeatherDataDao weatherDataDao;
    private LiveData<WeatherData> weatherData;

    public WeatherDataRepository(Application application){
        RoomDb roomDb = RoomDb.getDatabase(application);
        weatherDataDao  = roomDb.weatherDataDao();
        weatherData = weatherDataDao.getWeatherData();
    }

    public LiveData<WeatherData> getWeatherData() {
        return weatherData;
    }

    public void insert(WeatherData data) {
        RoomDb.databaseWriteExecutor.execute(() -> weatherDataDao.insert(data));
    }
    public void deleteAll() {
        RoomDb.databaseWriteExecutor.execute(() -> {
            weatherDataDao.deleteAll();
        });
    }
}
