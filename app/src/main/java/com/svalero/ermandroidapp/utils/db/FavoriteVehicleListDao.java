package com.svalero.ermandroidapp.utils.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.svalero.ermandroidapp.domain.FavoriteVehicle;

import java.util.List;

@Dao
public interface FavoriteVehicleListDao {

    @Query("select * from FavoriteVehicle")
    List<FavoriteVehicle> getAll();

    @Insert
    void insert(FavoriteVehicle favoriteVehicle);

    @Delete
    void delete(FavoriteVehicle favoriteVehicle);
}
