package com.svalero.ermandroidapp.model.EmgService;

import com.svalero.ermandroidapp.api.ERMApi;
import com.svalero.ermandroidapp.api.ERMApiInterface;
import com.svalero.ermandroidapp.contract.EmgService.EmgServiceDeleteContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmgServiceDeleteModel implements EmgServiceDeleteContract.Model {


    @Override
    public void deleteEmgService(Long id, OnDeleteEmgServiceListener listener) {
        ERMApiInterface ermApi = ERMApi.buildInstance();
        Call<Void> callEmgService = ermApi.deleteEmgService(id);
        callEmgService.enqueue(new Callback<Void>() {
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
