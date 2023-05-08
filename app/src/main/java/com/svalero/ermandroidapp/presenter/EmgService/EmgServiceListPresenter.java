package com.svalero.ermandroidapp.presenter.EmgService;

import com.svalero.ermandroidapp.contract.EmgService.EmgServiceListContract;
import com.svalero.ermandroidapp.domain.EmgService;
import com.svalero.ermandroidapp.model.EmgService.EmgServiceListModel;

import java.util.List;

public class EmgServiceListPresenter implements EmgServiceListContract.Presenter,EmgServiceListContract.Model.OnLoadEmgServiceListener {

    private EmgServiceListModel model;
    private EmgServiceListContract.View view;
    public EmgServiceListPresenter(EmgServiceListContract.View view){
        this.view = view;
        this.model= new EmgServiceListModel();
    }

    @Override
    public void loadAllEmgService(){
        model.loadAllEmgService(this);
    }

    @Override
    public void onLoadEmgServiceListSuccess(List<EmgService> emgServiceList) {
        view.showEmgServiceList(emgServiceList);
    }

    @Override
    public void onLoadEmgServiceListError(String message)  {
        view.showMessage(message);
    }
}
