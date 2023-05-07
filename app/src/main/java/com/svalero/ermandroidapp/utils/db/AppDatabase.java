package com.svalero.ermandroidapp.utils.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {FavoriteVehicle.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FavoriteVehicleListDao vehicleListDao();
}
