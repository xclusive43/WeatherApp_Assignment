package com.xclusive43.weatherapp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeMapper {
    public String getFormattedDatTime(long epochValue){
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(epochValue), ZoneId.of("UTC"));
        // Define the desired date time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM, yyyy");

        // Format the LocalDateTime using the formatter
        return dateTime.format(formatter);
    }
}
