package com.xclusive43.weatherapp.RoomDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WeatherData {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public long id;
    public String cityName;
    public String currentDate;
    public double temperature;
    public double feelsLike;
    public double windSpeed;
    public double humid;
    public double visibility;

    public WeatherData() {
    }

    public WeatherData(long id, String cityName, String currentDate, double temperature, double feelsLike, double windSpeed, double humid, double visibility) {
        this.id = id;
        this.cityName = cityName;
        this.currentDate = currentDate;
        this.temperature = temperature;
        this.feelsLike = feelsLike;
        this.windSpeed = windSpeed;
        this.humid = humid;
        this.visibility = visibility;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getHumid() {
        return humid;
    }

    public void setHumid(double humid) {
        this.humid = humid;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }
}
