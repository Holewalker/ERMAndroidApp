package com.svalero.ermandroidapp.model.EmgService;

import com.svalero.ermandroidapp.api.ERMApi;
import com.svalero.ermandroidapp.api.ERMApiInterface;
import com.svalero.ermandroidapp.contract.EmgService.EmgServiceAddContract;
import com.svalero.ermandroidapp.domain.EmgService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmgServicelAddModel implements EmgServiceAddContract.Model {


    @Override
    public void addEmgService(EmgService emgService, OnAddEmgServiceListener listener) {
        ERMApiInterface ermApi = ERMApi.buildInstance();
        Call<EmgService> callEmgService = ermApi.addEmgService(emgService);
        callEmgService.enqueue(new Callback<EmgService>() {
            @Override
            public void onResponse(Call<EmgService> call, Response<EmgService> response) {
                EmgService emgService = response.body();
                listener.onAddSuccess(emgService);
            }

            @Override
            public void onFailure(Call<EmgService> call, Throwable t) {
                t.printStackTrace();
                String message = "Error invocando a la operación";
                listener.onAddError(message);
            }
        });
    }
}
