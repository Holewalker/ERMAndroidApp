package com.svalero.ermandroidapp.presenter.EmgVehicle;


import com.svalero.ermandroidapp.contract.EmgVehicle.EmgVehicleEditContract;
import com.svalero.ermandroidapp.domain.EmgVehicle;
import com.svalero.ermandroidapp.model.EmgVehicle.EmgVehicleEditModel;
import com.svalero.ermandroidapp.view.EmgVehicleAddView;

public class EmgVehicleEditPresenter implements EmgVehicleEditContract.Presenter, EmgVehicleEditContract.Model.OnEditEmgVehicleListener {
    private EmgVehicleEditModel model;
    private EmgVehicleAddView view;

    public EmgVehicleEditPresenter(EmgVehicleAddView view) {
        model = new EmgVehicleEditModel();
        this.view = view;
    }


    @Override
    public void emgVehicleEdit(Long id, EmgVehicle EmgVehicle) {
        model.editEmgVehicle(id, EmgVehicle, this);
    }


    @Override
    public void onEditSuccess(EmgVehicle EmgVehicle) {
        view.showMessage("El EmgVehicle se ha editado correctamente!");
    }

    @Override
    public void onEditError(String message) {
        view.showError(message);
    }

}
