package com.svalero.ermandroidapp.domain;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import com.svalero.ermandroidapp.domain.EmgVehicle;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(indices = {@Index(value = {"id"}, unique = true)})

public class FavoriteVehicle implements Serializable {


    @PrimaryKey(autoGenerate = true)
    private long id;
    private String vin;
    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public FavoriteVehicle(String vin, String type) {
        this.vin = vin;
        this.type = type;
    }
}
