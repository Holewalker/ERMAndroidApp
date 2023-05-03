package com.svalero.ermandroidapp.model.EmgPersonal;

import com.svalero.ermandroidapp.api.ERMApi;
import com.svalero.ermandroidapp.api.ERMApiInterface;
import com.svalero.ermandroidapp.contract.EmgPersonal.EmgPersonalEditContract;
import com.svalero.ermandroidapp.domain.EmgPersonal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmgPersonalEditModel implements EmgPersonalEditContract.Model {


    @Override
    public void editEmgPersonal(Long id, EmgPersonal emgPersonal, OnEditEmgPersonalListener listener) {
        ERMApiInterface ermApi = ERMApi.buildInstance();
        Call<EmgPersonal> callEmgPersonal = ermApi.updateEmgPersonal(id, emgPersonal);
        callEmgPersonal.enqueue(new Callback<EmgPersonal>() {
            @Override
            public void onResponse(Call<EmgPersonal> call, Response<EmgPersonal> response) {
                EmgPersonal emgPersonal = response.body();
                listener.onEditSuccess(emgPersonal);
            }

            @Override
            public void onFailure(Call<EmgPersonal> call, Throwable t) {
                t.printStackTrace();
                String message = "Error invocando a la operación";
                listener.onEditError(message);
            }
        });
    }
}
