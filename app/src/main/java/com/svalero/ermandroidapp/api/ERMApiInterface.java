package com.svalero.ermandroidapp.api;

import com.svalero.ermandroidapp.domain.EmgPersonal;
import com.svalero.ermandroidapp.domain.EmgService;
import com.svalero.ermandroidapp.domain.EmgVehicle;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ERMApiInterface {
    //EMG VEHICLE API CALLS
    @GET("EmergencyVehicles")
    Call<List<EmgVehicle>> getEmgVehicleList();

    @GET("EmergencyVehicles")
    Call<List<EmgVehicle>> getEmgVehicle(@Query("id") Long id);

    @GET("EmergencyVehicles")
    Call<List<EmgVehicle>> getEmgVehicleFromService(@Query("emgService") Long idService);

    @POST("EmergencyVehicles")
    Call<EmgVehicle> addEmgVehicle(@Body EmgVehicle emgVehicle);

    @DELETE("EmergencyVehicles/{id}")
    Call<Void> deleteEmgVehicle(@Path("id") Long id);

    @PUT("EmergencyVehicles/{id}")
    Call<EmgVehicle> updateEmgVehicle(@Path("id") Long id, @Body EmgVehicle emgvehicle);
    //EmgPersonal
    @GET("EmgPersonal")
    Call<List<EmgPersonal>> getEmgPersonalList();

    @GET("EmgPersonal")
    Call<EmgPersonal> getEmgPersonal(@Query("id") Long id);

    @POST("EmgPersonal")
    Call<EmgPersonal> addEmgPersonal(@Body EmgPersonal emgPersonal);

    @DELETE("EmgPersonal/{id}")
    Call<Void> deleteEmgPersonal(@Path("id") Long id);

    @PUT("EmgPersonal/{id}")
    Call<EmgPersonal> updateEmgPersonal(@Path("id") Long id, @Body EmgPersonal emgPersonal);



    @GET("EmergencyServices")
    Call<List<EmgService>> getEmgServiceList();

    @GET("EmergencyServices")
    Call<EmgService> getEmgService(@Query("id") Long id);

    @POST("EmergencyServices")
    Call<EmgService> addEmgService(@Body EmgService emgService);

    @DELETE("EmergencyServices/{id}")
    Call<Void> deleteEmgService(@Path("id") Long id);

    @PUT("EmergencyServices/{id}")
    Call<EmgService> updateEmgService(@Path("id") Long id, @Body EmgService emgService);

}
