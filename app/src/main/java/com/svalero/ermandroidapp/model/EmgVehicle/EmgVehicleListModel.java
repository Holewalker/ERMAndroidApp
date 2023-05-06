package com.svalero.ermandroidapp.model.EmgVehicle;

import android.util.Log;

import com.svalero.ermandroidapp.api.ERMApi;
import com.svalero.ermandroidapp.api.ERMApiInterface;
import com.svalero.ermandroidapp.contract.EmgVehicle.EmgVehicleListContract;
import com.svalero.ermandroidapp.domain.EmgVehicle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmgVehicleListModel implements EmgVehicleListContract.Model {

    @Override
    public void loadAllEmgVehicle(OnLoadEmgVehicleListener listener) {
        ERMApiInterface ermApi = ERMApi.buildInstance();
        Call<List<EmgVehicle>> callEmgVehicle = ermApi.getEmgVehicleList();
        callEmgVehicle.enqueue(new Callback<List<EmgVehicle>>() {
            @Override
            public void onResponse(Call<List<EmgVehicle>> call, Response<List<EmgVehicle>> response) {
                List<EmgVehicle> emgVehicleList = response.body();
                listener.onLoadEmgVehicleListSuccess(emgVehicleList);
            }

            @Override
            public void onFailure(Call<List<EmgVehicle>> call, Throwable t) {
                t.printStackTrace();
                String message = "Error invocando a la operación";
                listener.onLoadEmgVehicleListError(message);
            }
        });

    }


    @Override
    public void loadAllEmgVehicleByServiceId(Long serviceId, OnLoadEmgVehicleListener listener) {
        ERMApiInterface ermApi = ERMApi.buildInstance();
        Call<List<EmgVehicle>> callEmgVehicle = ermApi.getEmgVehicleFromService(serviceId);

        callEmgVehicle.enqueue(new Callback<List<EmgVehicle>>() {
            @Override
            public void onResponse(Call<List<EmgVehicle>> call, Response<List<EmgVehicle>> response) {
                List<EmgVehicle> emgVehicleList = response.body();
                Log.d("data", String.valueOf(response.body()));
                listener.onLoadEmgVehicleListServiceSuccess(emgVehicleList);
            }

            @Override
            public void onFailure(Call<List<EmgVehicle>> call, Throwable t) {
                t.printStackTrace();
                Log.d("data", "OOPS");
                String message = "Error invocando a la operación";
                listener.onLoadEmgVehicleListServiceError(message);
            }
        });

    }
}



