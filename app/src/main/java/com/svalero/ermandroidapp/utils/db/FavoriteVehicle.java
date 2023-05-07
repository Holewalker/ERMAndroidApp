package com.svalero.ermandroidapp.utils.db;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.svalero.ermandroidapp.domain.EmgVehicle;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(indices = {@Index(value = {"id"}, unique = true)})
public class FavoriteVehicle implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private EmgVehicle emgVehicle;

}
