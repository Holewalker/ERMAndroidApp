package com.svalero.ermandroidapp.model.EmgService;

import com.svalero.ermandroidapp.api.ERMApi;
import com.svalero.ermandroidapp.api.ERMApiInterface;
import com.svalero.ermandroidapp.contract.EmgService.EmgServiceDetailsContract;
import com.svalero.ermandroidapp.domain.EmgService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmgServiceDetailsModel implements EmgServiceDetailsContract.Model {



    @Override
    public void loadEmgServiceById(OnLoadEmgServiceListener listener, Long id) {
        ERMApiInterface ermApi = ERMApi.buildInstance();
        Call<EmgService> callEmgService = ermApi.getEmgService(id);
        callEmgService.enqueue(new Callback<EmgService>() {
            @Override
            public void onResponse(Call<EmgService> call, Response<EmgService> response) {
                EmgService emgService = response.body();
                listener.onLoadEmgServiceDetailsSuccess(emgService);
            }

            @Override
            public void onFailure(Call<EmgService> call, Throwable t) {
                t.printStackTrace();
                String message = "Error invocando a la operación";
                listener.onLoadEmgServiceDetailsError(message);
            }
        });
    }


}
