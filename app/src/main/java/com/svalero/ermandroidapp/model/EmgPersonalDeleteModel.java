package com.svalero.ermandroidapp.model;

import com.svalero.ermandroidapp.api.ERMApi;
import com.svalero.ermandroidapp.api.ERMApiInterface;
import com.svalero.ermandroidapp.contract.EmgPersonalAddContract;
import com.svalero.ermandroidapp.contract.EmgPersonalDeleteContract;
import com.svalero.ermandroidapp.domain.EmgPersonal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmgPersonalDeleteModel implements EmgPersonalDeleteContract.Model {


    @Override
    public void deleteEmgPersonal(Long id, OnDeleteEmgPersonalListener listener) {
        ERMApiInterface ermApi = ERMApi.buildInstance();
        Call<Void> callEmgPersonal = ermApi.deleteEmgPersonal(id);
        callEmgPersonal.enqueue(new Callback<Void>() {
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
