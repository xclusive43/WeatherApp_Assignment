package com.xclusive43.weatherapp.Retrofit;

import com.xclusive43.weatherapp.Model.WeatherResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("weather")
    Call<WeatherResponseModel> getCurrentWeather(
            @Query("q") String cityName,
            @Query("appid") String apiKey,
            @Query("units") String units
    );
}
