package com.svalero.ermandroidapp.model.EmgService;

import com.svalero.ermandroidapp.api.ERMApi;
import com.svalero.ermandroidapp.api.ERMApiInterface;
import com.svalero.ermandroidapp.contract.EmgService.EmgServiceEditContract;
import com.svalero.ermandroidapp.domain.EmgService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmgServiceEditModel implements EmgServiceEditContract.Model {


    @Override
    public void editEmgService(Long id, EmgService emgService, OnEditEmgServiceListener listener) {
        ERMApiInterface ermApi = ERMApi.buildInstance();
        Call<EmgService> callEmgService = ermApi.updateEmgService(id, emgService);
        callEmgService.enqueue(new Callback<EmgService>() {
            @Override
            public void onResponse(Call<EmgService> call, Response<EmgService> response) {
                EmgService emgService = response.body();
                listener.onEditSuccess(emgService);
            }

            @Override
            public void onFailure(Call<EmgService> call, Throwable t) {
                t.printStackTrace();
                String message = "Error invocando a la operación";
                listener.onEditError(message);
            }
        });
    }
}
