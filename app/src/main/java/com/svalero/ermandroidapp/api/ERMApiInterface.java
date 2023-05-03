package com.svalero.ermandroidapp.api;

import com.svalero.ermandroidapp.domain.EmgPersonal;
import com.svalero.ermandroidapp.domain.EmgService;
import com.svalero.ermandroidapp.domain.EmgVehicle;

import java.util.List;

import lombok.experimental.Delegate;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ERMApiInterface {
    //EMG VEHICLE API CALLS
    @GET("EmergencyVehicles/{id}")
    Call<List<EmgVehicle>> getEmgVehicleList();

    @GET("EmergencyVehicles/{id}")
    Call<EmgVehicle> getEmgVehicle(@Path("id") long id);

    @POST("EmergencyVehicles")
    Call<EmgVehicle> addEmgVehicle(@Body EmgVehicle emgVehicle);

    @DELETE("EmergencyVehicles/{id}")
    Call<Void> deleteEmgVehicle(@Path("id") long id);

    @PUT("EmergencyVehicles/{id}")
    Call<EmgVehicle> updateEmgVehicle(@Path("id") long id, @Body EmgVehicle emgvehicle);
    //EmgPersonal
    @GET("EmgPersonal/{id}")
    Call<List<EmgPersonal>> getEmgPersonalList();

    @GET("EmgPersonal/{id}")
    Call<EmgPersonal> getEmgPersonal(@Path("id") long id);

    @POST("EmgPersonal")
    Call<EmgPersonal> addEmgPersonal(@Body EmgPersonal emgPersonal);

    @DELETE("EmgPersonal/{id}")
    Call<Void> deleteEmgPersonal(@Path("id") long id);

    @PUT("EmgPersonal/{id}")
    Call<EmgPersonal> updateEmgPersonal(@Path("id") long id, @Body EmgPersonal emgPersonal);



    @GET("EmgService/{id}")
    Call<List<EmgService>> getEmgServiceList();

    @GET("EmgService/{id}")
    Call<EmgService> getEmgService(@Path("id") long id);

    @POST("EmgService")
    Call<EmgService> addEmgService(@Body EmgService emgService);

    @DELETE("EmgService/{id}")
    Call<Void> deleteEmgService(@Path("id") long id);

    @PUT("EmgService/{id}")
    Call<EmgService> updateEmgService(@Path("id") long id, @Body EmgService emgService);

}
