package com.svalero.ermandroidapp.presenter.EmgVehicle;

import com.svalero.ermandroidapp.contract.EmgVehicle.EmgVehicleListContract;
import com.svalero.ermandroidapp.domain.EmgVehicle;
import com.svalero.ermandroidapp.model.EmgVehicle.EmgVehicleListModel;

import java.util.List;

public class EmgVehicleListPresenter implements EmgVehicleListContract.Presenter,EmgVehicleListContract.Model.OnLoadEmgVehicleListener {

    private EmgVehicleListModel model;
    private EmgVehicleListContract.View view;
    public EmgVehicleListPresenter(EmgVehicleListContract.View view){
        this.view = view;
        this.model= new EmgVehicleListModel();
    }

    @Override
    public void loadAllEmgVehicle(){
        model.loadAllEmgVehicle(this);
    }

    @Override
    public void loadAllEmgVehicleByServiceId(Long id) {
        model.loadAllEmgVehicleByServiceId(id, this);
    }

    @Override
    public void onLoadEmgVehicleListSuccess(List<EmgVehicle> emgVehicleList) {
        view.showEmgVehicleList(emgVehicleList);
    }

    @Override
    public void onLoadEmgVehicleListError(String message)  {
        view.showMessage(message);
    }
    @Override
    public void onLoadEmgVehicleListServiceSuccess(List<EmgVehicle> emgVehicleList) {
        view.showEmgVehicleList(emgVehicleList);
    }

    @Override
    public void onLoadEmgVehicleListServiceError(String message)  {
        view.showMessage(message);
    }
}
