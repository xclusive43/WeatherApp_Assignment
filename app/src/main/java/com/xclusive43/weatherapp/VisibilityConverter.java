package com.xclusive43.weatherapp;

import android.util.Log;

public class VisibilityConverter {
    public double metersToKilometers(double meters) {
        Log.d("VISI", String.valueOf(meters));
        return meters * 0.001;
    }
}
