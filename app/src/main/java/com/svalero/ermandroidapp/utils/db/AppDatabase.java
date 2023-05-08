package com.svalero.ermandroidapp.utils.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.svalero.ermandroidapp.domain.FavoriteVehicle;

@Database(entities = {FavoriteVehicle.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FavoriteVehicleListDao vehicleListDao();
}
