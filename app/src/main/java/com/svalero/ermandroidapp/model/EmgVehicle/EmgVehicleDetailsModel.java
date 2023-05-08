package com.svalero.ermandroidapp.model.EmgVehicle;

import android.util.Log;

import com.svalero.ermandroidapp.api.ERMApi;
import com.svalero.ermandroidapp.api.ERMApiInterface;
import com.svalero.ermandroidapp.contract.EmgVehicle.EmgVehicleDetailsContract;
import com.svalero.ermandroidapp.domain.EmgVehicle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmgVehicleDetailsModel implements EmgVehicleDetailsContract.Model {


    @Override
    public void loadEmgVehicleById(Long id, OnLoadEmgVehicleListener listener) {
        ERMApiInterface ermApi = ERMApi.buildInstance();
        Call<List<EmgVehicle>> callEmgVehicle = ermApi.getEmgVehicle(id);
        callEmgVehicle.enqueue(new Callback<List<EmgVehicle>>() {
            @Override
            public void onResponse(Call<List<EmgVehicle>> call, Response<List<EmgVehicle>> response) {
                Log.d("Vehicle data", String.valueOf(response.body()));
                List<EmgVehicle> emgVehicle = response.body();
                listener.onLoadEmgVehicleDetailsSuccess(emgVehicle);
            }

            @Override
            public void onFailure(Call<List<EmgVehicle>> call, Throwable t) {
                t.printStackTrace();
                String message = "Error invocando a la operación";
                listener.onLoadEmgVehicleDetailsError(message);
            }
        });
    }


}
