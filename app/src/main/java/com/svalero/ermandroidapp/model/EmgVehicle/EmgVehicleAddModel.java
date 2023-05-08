package com.svalero.ermandroidapp.model.EmgVehicle;

import com.svalero.ermandroidapp.api.ERMApi;
import com.svalero.ermandroidapp.api.ERMApiInterface;
import com.svalero.ermandroidapp.contract.EmgVehicle.EmgVehicleAddContract;
import com.svalero.ermandroidapp.domain.EmgVehicle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmgVehicleAddModel implements EmgVehicleAddContract.Model {


    @Override
    public void addEmgVehicle(EmgVehicle emgVehicle, OnAddEmgVehicleListener listener) {
        ERMApiInterface ermApi = ERMApi.buildInstance();
        Call<EmgVehicle> callEmgVehicle = ermApi.addEmgVehicle(emgVehicle);
        callEmgVehicle.enqueue(new Callback<EmgVehicle>() {
            @Override
            public void onResponse(Call<EmgVehicle> call, Response<EmgVehicle> response) {
                EmgVehicle emgVehicle = response.body();
                listener.onAddSuccess(emgVehicle);
            }

            @Override
            public void onFailure(Call<EmgVehicle> call, Throwable t) {
                t.printStackTrace();
                String message = "Error invocando a la operación";
                listener.onAddError(message);
            }
        });
    }
}
