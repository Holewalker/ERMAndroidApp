package com.svalero.ermandroidapp.model;

import com.svalero.ermandroidapp.api.ERMApi;
import com.svalero.ermandroidapp.api.ERMApiInterface;
import com.svalero.ermandroidapp.contract.EmgPersonalAddContract;
import com.svalero.ermandroidapp.contract.EmgPersonalDetailsContract;
import com.svalero.ermandroidapp.domain.EmgPersonal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmgPersonalAddModel implements EmgPersonalAddContract.Model {


    @Override
    public void addEmgPersonal(EmgPersonal emgPersonal, OnAddEmgPersonalListener listener) {
        ERMApiInterface ermApi = ERMApi.buildInstance();
        Call<EmgPersonal> callEmgPersonal = ermApi.addEmgPersonal(emgPersonal);
        callEmgPersonal.enqueue(new Callback<EmgPersonal>() {
            @Override
            public void onResponse(Call<EmgPersonal> call, Response<EmgPersonal> response) {
                EmgPersonal emgPersonal = response.body();
                listener.onAddSuccess(emgPersonal);
            }

            @Override
            public void onFailure(Call<EmgPersonal> call, Throwable t) {
                t.printStackTrace();
                String message = "Error invocando a la operación";
                listener.onAddError(message);
            }
        });
    }
}
