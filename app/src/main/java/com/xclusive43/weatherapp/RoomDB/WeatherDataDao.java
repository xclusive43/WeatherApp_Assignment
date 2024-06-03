package com.xclusive43.weatherapp.RoomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.DeleteColumn;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface WeatherDataDao {
    @Query("SELECT * FROM WeatherData LIMIT 1")
    LiveData<WeatherData> getWeatherData();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(WeatherData weatherData);

    @Query("DELETE FROM WeatherData")
    void deleteAll();
}
