package com.xclusive43.weatherapp.RoomDB;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {WeatherData.class}, version = 1)

public abstract class RoomDb extends RoomDatabase {

    public abstract WeatherDataDao weatherDataDao();

    private static volatile RoomDb INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static RoomDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    RoomDb.class, "weather_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
