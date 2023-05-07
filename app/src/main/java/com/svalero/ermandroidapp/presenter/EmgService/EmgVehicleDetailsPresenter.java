package com.svalero.ermandroidapp.presenter.EmgService;

import com.svalero.ermandroidapp.contract.EmgVehicle.EmgVehicleDetailsContract;
import com.svalero.ermandroidapp.domain.EmgVehicle;
import com.svalero.ermandroidapp.model.EmgVehicle.EmgVehicleDetailsModel;


public class EmgVehicleDetailsPresenter implements EmgVehicleDetailsContract.Presenter, EmgVehicleDetailsContract.Model.OnLoadEmgVehicleListener {

    private EmgVehicleDetailsModel model;
    private EmgVehicleDetailsContract.View view;
    private long id;

    public EmgVehicleDetailsPresenter(EmgVehicleDetailsContract.View view) {
        this.view = view;
        this.model = new EmgVehicleDetailsModel();
    }

    @Override
    public void onLoadEmgVehicleDetailsSuccess(EmgVehicle emgVehicle) {
        view.showEmgVehicle(emgVehicle);
    }

    @Override
    public void onLoadEmgVehicleDetailsError(String message) {

    }

    @Override
    public void loadEmgVehicle(Long id) {
        model.loadEmgVehicleById(id, this);
    }
}
