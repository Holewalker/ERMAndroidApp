package com.svalero.ermandroidapp.model.EmgService;

import com.svalero.ermandroidapp.api.ERMApi;
import com.svalero.ermandroidapp.api.ERMApiInterface;
import com.svalero.ermandroidapp.contract.EmgService.EmgServiceListContract;
import com.svalero.ermandroidapp.domain.EmgService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmgServiceListModel implements EmgServiceListContract.Model {

    @Override
    public void loadAllEmgService(OnLoadEmgServiceListener listener) {
        ERMApiInterface ermApi = ERMApi.buildInstance();
        Call<List<EmgService>> callEmgService = ermApi.getEmgServiceList();
        callEmgService.enqueue(new Callback<List<EmgService>>() {
            @Override
            public void onResponse(Call<List<EmgService>> call, Response<List<EmgService>> response) {
                List<EmgService> emgServiceList = response.body();
                listener.onLoadEmgServiceListSuccess(emgServiceList);
            }

            @Override
            public void onFailure(Call<List<EmgService>> call, Throwable t) {
                t.printStackTrace();
                String message = "Error invocando a la operación";
                listener.onLoadEmgServiceListError(message);
            }
        });

    }
}



