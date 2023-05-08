package com.svalero.ermandroidapp.model.EmgVehicle;

import com.svalero.ermandroidapp.api.ERMApi;
import com.svalero.ermandroidapp.api.ERMApiInterface;
import com.svalero.ermandroidapp.contract.EmgVehicle.EmgVehicleEditContract;
import com.svalero.ermandroidapp.domain.EmgVehicle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmgVehicleEditModel implements EmgVehicleEditContract.Model {


    @Override
    public void editEmgVehicle(Long id, EmgVehicle emgVehicle, OnEditEmgVehicleListener listener) {
        ERMApiInterface ermApi = ERMApi.buildInstance();
        Call<EmgVehicle> callEmgVehicle = ermApi.updateEmgVehicle(id, emgVehicle);
        callEmgVehicle.enqueue(new Callback<EmgVehicle>() {
            @Override
            public void onResponse(Call<EmgVehicle> call, Response<EmgVehicle> response) {
                EmgVehicle emgVehicle = response.body();
                listener.onEditSuccess(emgVehicle);
            }

            @Override
            public void onFailure(Call<EmgVehicle> call, Throwable t) {
                t.printStackTrace();
                String message = "Error invocando a la operación";
                listener.onEditError(message);
            }
        });
    }
}
