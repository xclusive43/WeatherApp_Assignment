package com.xclusive43.weatherapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponseModel {
    @SerializedName("coord")
    public Coord coord;

    @SerializedName("weather")
    public List<Weather> weather;
    @SerializedName("base")
    public String base;
    @SerializedName("main")
    public Main main;
    @SerializedName("visibility")
    public double visibility;
    @SerializedName("wind")
    public Wind wind;
    @SerializedName("clouds")
    public Clouds clouds;
    @SerializedName("dt")
    public long dt;
    @SerializedName("sys")
    public Sys sys;
    @SerializedName("timezone")
    public int timezone;
    @SerializedName("id")
    public long id;
    @SerializedName("name")
    public String name;
    @SerializedName("cod")
    public int cod;

    public class Coord {
        @SerializedName("lon")
        public double lon;
        @SerializedName("lat")
        public double lat;
    }

    public class Weather {
        @SerializedName("id")
        public int id;
        @SerializedName("main")
        public String main;
        @SerializedName("description")
        public String description;
        @SerializedName("icon")
        public String icon;
    }

    public class Main {
        @SerializedName("temp")
        public double temp;

        @SerializedName("feelsLike")
        public double feelsLike;

        @SerializedName("tempMin")
        public double tempMin;

        @SerializedName("tempMax")
        public double tempMax;

        @SerializedName("pressure")
        public int pressure;

        @SerializedName("humidity")
        public int humidity;
    }

    public class Clouds {
        @SerializedName("all")
        public int all;
    }

    public class Wind {
        @SerializedName("speed")
        public double speed;

        @SerializedName("deg")
        public int deg;
    }

    public class Sys {
        @SerializedName("type")
        public int type;

        @SerializedName("id")
        public int id;

        @SerializedName("country")
        public String country;

        @SerializedName("sunrise")
        public long sunrise;

        @SerializedName("sunset")
        public long sunset;
    }

    public WeatherResponseModel() {
    }

    public WeatherResponseModel(Coord coord, List<Weather> weather, String base, Main main, int visibility, Wind wind, Clouds clouds, long dt, Sys sys, int timezone, long id, String name, int cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "WeatherResponseModel{" +
                "coord=" + coord +
                ", weather=" + weather +
                ", base='" + base + '\'' +
                ", main=" + main +
                ", visibility=" + visibility +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", dt=" + dt +
                ", sys=" + sys +
                ", timezone=" + timezone +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                '}';
    }
}


