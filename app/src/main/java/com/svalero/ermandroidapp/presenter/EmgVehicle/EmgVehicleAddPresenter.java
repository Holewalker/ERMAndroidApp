package com.svalero.ermandroidapp.presenter.EmgVehicle;

import com.svalero.ermandroidapp.contract.EmgVehicle.EmgVehicleAddContract;
import com.svalero.ermandroidapp.domain.EmgVehicle;
import com.svalero.ermandroidapp.model.EmgVehicle.EmgVehicleAddModel;
import com.svalero.ermandroidapp.view.EmgVehicleAddView;

public class EmgVehicleAddPresenter implements EmgVehicleAddContract.Presenter, EmgVehicleAddContract.Model.OnAddEmgVehicleListener {

    private EmgVehicleAddModel model;
    private EmgVehicleAddView view;

    public EmgVehicleAddPresenter(EmgVehicleAddView view) {
        model = new EmgVehicleAddModel();
        this.view = view;
    }

    @Override
    public void addEmgVehicle(EmgVehicle emgVehicle) {
        model.addEmgVehicle(emgVehicle, this);
    }

    @Override
    public void onAddSuccess(EmgVehicle emgVehicle) {

    }

    @Override
    public void onAddError(String message) {
        view.showError(message);
    }
}
