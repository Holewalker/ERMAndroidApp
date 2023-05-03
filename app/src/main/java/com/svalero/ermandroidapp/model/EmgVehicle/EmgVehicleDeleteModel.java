package com.svalero.ermandroidapp.model.EmgVehicle;

import com.svalero.ermandroidapp.api.ERMApi;
import com.svalero.ermandroidapp.api.ERMApiInterface;
import com.svalero.ermandroidapp.contract.EmgVehicle.EmgVehicleDeleteContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmgVehicleDeleteModel implements EmgVehicleDeleteContract.Model {


    @Override
    public void deleteEmgVehicle(Long id, OnDeleteEmgVehicleListener listener) {
        ERMApiInterface ermApi = ERMApi.buildInstance();
        Call<Void> callEmgVehicle = ermApi.deleteEmgVehicle(id);
        callEmgVehicle.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                listener.onDeleteSuccess();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                t.printStackTrace();
                String message = "Error invocando a la operación";
                listener.onDeleteError(message);
            }
        });
    }
}
