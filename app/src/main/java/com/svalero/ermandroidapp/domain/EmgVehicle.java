package com.svalero.ermandroidapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmgVehicle implements Serializable {

    private long id;

    private long emgServiceId;

    private EmgService emgServiceVehicle;
    private String model;

    private String vin;

    private String type;

    private int operStatus;

    //initial value always false. Vehicles are not created on route.
    private boolean onRoute = false;

    private boolean available = true;

    private String location;

    private double lat;

    private double lon;

    private String lastMaintenance;

    public EmgVehicle(long emgServiceId, String model, String vin, String type, int operStatus, String location, double lat, double lon, String lastMaintenance) {
        this.emgServiceId = emgServiceId;
        this.model = model;
        this.vin = vin;
        this.type = type;
        this.operStatus = operStatus;
        this.onRoute = false;
        this.available = true;
        this.location = location;
        this.lat = lat;
        this.lon = lon;
        this.lastMaintenance = lastMaintenance;
    }
}
