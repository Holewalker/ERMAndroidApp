package com.svalero.ermandroidapp.model.EmgPersonal;

import com.svalero.ermandroidapp.api.ERMApi;
import com.svalero.ermandroidapp.api.ERMApiInterface;
import com.svalero.ermandroidapp.contract.EmgPersonal.EmgPersonalListContract;
import com.svalero.ermandroidapp.domain.EmgPersonal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmgPersonalListModel implements EmgPersonalListContract.Model {

    @Override
    public void loadAllEmgPersonal(OnLoadEmgPersonalListener listener) {
        ERMApiInterface ermApi = ERMApi.buildInstance();
        Call<List<EmgPersonal>> callEmgPersonal = ermApi.getEmgPersonalList();
        callEmgPersonal.enqueue(new Callback<List<EmgPersonal>>() {
            @Override
            public void onResponse(Call<List<EmgPersonal>> call, Response<List<EmgPersonal>> response) {
                List<EmgPersonal> emgPersonalList = response.body();
                listener.onLoadEmgPersonalListSuccess(emgPersonalList);
            }

            @Override
            public void onFailure(Call<List<EmgPersonal>> call, Throwable t) {
                t.printStackTrace();
                String message = "Error invocando a la operación";
                listener.onLoadEmgPersonalListError(message);
            }
        });

    }
}



