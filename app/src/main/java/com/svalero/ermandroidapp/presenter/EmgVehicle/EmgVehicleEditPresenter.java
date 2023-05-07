package com.svalero.ermandroidapp.presenter.EmgVehicle;


import com.svalero.ermandroidapp.contract.EmgService.EmgServiceEditContract;
import com.svalero.ermandroidapp.domain.EmgService;
import com.svalero.ermandroidapp.model.EmgService.EmgServiceEditModel;
import com.svalero.ermandroidapp.view.EmgServiceAddView;

public class EmgVehicleEditPresenter implements EmgServiceEditContract.Presenter, EmgServiceEditContract.Model.OnEditEmgServiceListener {
    private EmgServiceEditModel model;
    private EmgServiceAddView view;

    public EmgVehicleEditPresenter(EmgServiceAddView view) {
        model = new EmgServiceEditModel();
        this.view = view;
    }


    @Override
    public void emgServiceEdit(Long id, EmgService emgService) {
        model.emgServiceEdit(id, emgService, this);
    }


    @Override
    public void onEditSuccess(EmgService emgService) {
        view.showMessage("El emgService se ha editado correctamente!");
    }

    @Override
    public void onEditError(String message) {
        view.showError(message);
    }

}
