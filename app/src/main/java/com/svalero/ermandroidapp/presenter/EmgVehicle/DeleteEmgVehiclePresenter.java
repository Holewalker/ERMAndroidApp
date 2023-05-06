package com.svalero.ermandroidapp.presenter.EmgVehicle;


import com.svalero.ermandroidapp.adapter.EmgVehicleAdapter;
import com.svalero.ermandroidapp.contract.EmgVehicle.EmgVehicleDeleteContract;
import com.svalero.ermandroidapp.model.EmgVehicle.EmgVehicleDeleteModel;

public class DeleteEmgVehiclePresenter implements EmgVehicleDeleteContract.Presenter, EmgVehicleDeleteContract.Model.OnDeleteEmgVehicleListener {

    private EmgVehicleDeleteModel model;
    private EmgVehicleAdapter view;

    public DeleteEmgVehiclePresenter(EmgVehicleAdapter view) {
        model = new EmgVehicleDeleteModel();
        this.view = view;
    }

    @Override
    public void onDeleteEmgVehicleSuccess(String message) {
        view.showMessage(message);
    }

    @Override
    public void onDeleteEmgVehicleError(String error) {
        view.showMessage(error);
    }

    @Override
    public void onDeleteSuccess() {

    }

    @Override
    public void onDeleteError(String error) {
        view.showError(error);
    }


    public void deleteEmgVehicle(long id) {
        model.deleteEmgVehicle(id, this);
    }
}
