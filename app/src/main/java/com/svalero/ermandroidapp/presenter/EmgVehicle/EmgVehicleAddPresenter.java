package com.svalero.ermandroidapp.presenter.EmgVehicle;

import com.svalero.ermandroidapp.contract.EmgService.EmgServiceAddContract;
import com.svalero.ermandroidapp.domain.EmgService;
import com.svalero.ermandroidapp.model.EmgService.EmgServiceAddModel;
import com.svalero.ermandroidapp.view.EmgServiceAddView;

public class EmgVehicleAddPresenter implements EmgServiceAddContract.Presenter, EmgServiceAddContract.Model.OnAddEmgServiceListener {

    private EmgServiceAddModel model;
    private EmgServiceAddView view;

    public EmgVehicleAddPresenter(EmgServiceAddView view) {
        model = new EmgServiceAddModel();
        this.view = view;
    }

    @Override
    public void addEmgService(EmgService emgService) {
        model.addEmgService(emgService, this);
    }

    @Override
    public void onAddSuccess(EmgService emgService) {
        view.showMessage("El emgServiceo: " + emgService.getLocation() + " se ha añadido correctamente!");

    }

    @Override
    public void onAddError(String message) {
        view.showError(message);
    }
}
