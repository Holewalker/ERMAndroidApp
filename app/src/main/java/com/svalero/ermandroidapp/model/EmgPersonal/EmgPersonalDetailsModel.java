package com.svalero.ermandroidapp.model.EmgPersonal;

import com.svalero.ermandroidapp.api.ERMApi;
import com.svalero.ermandroidapp.api.ERMApiInterface;
import com.svalero.ermandroidapp.contract.EmgPersonal.EmgPersonalDetailsContract;
import com.svalero.ermandroidapp.domain.EmgPersonal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmgPersonalDetailsModel implements EmgPersonalDetailsContract.Model {



    @Override
    public void loadEmgPersonalById(OnLoadEmgPersonalListener listener, Long id) {
        ERMApiInterface ermApi = ERMApi.buildInstance();
        Call<EmgPersonal> callEmgPersonal = ermApi.getEmgPersonal(id);
        callEmgPersonal.enqueue(new Callback<EmgPersonal>() {
            @Override
            public void onResponse(Call<EmgPersonal> call, Response<EmgPersonal> response) {
                EmgPersonal emgPersonal = response.body();
                listener.onLoadEmgPersonalDetailsSuccess(emgPersonal);
            }

            @Override
            public void onFailure(Call<EmgPersonal> call, Throwable t) {
                t.printStackTrace();
                String message = "Error invocando a la operación";
                listener.onLoadEmgPersonalDetailsError(message);
            }
        });
    }


}
