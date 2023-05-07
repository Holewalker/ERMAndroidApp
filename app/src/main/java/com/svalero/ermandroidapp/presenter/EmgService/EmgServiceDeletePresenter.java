package com.svalero.ermandroidapp.presenter.EmgService;


import com.svalero.ermandroidapp.adapter.EmgServiceAdapter;
import com.svalero.ermandroidapp.contract.EmgService.EmgServiceDeleteContract;
import com.svalero.ermandroidapp.model.EmgService.EmgServiceDeleteModel;

public class EmgServiceDeletePresenter implements EmgServiceDeleteContract.Presenter, EmgServiceDeleteContract.Model.OnDeleteEmgServiceListener {

    private EmgServiceDeleteModel model;
    private EmgServiceAdapter view;

    public EmgServiceDeletePresenter(EmgServiceAdapter view) {
        model = new EmgServiceDeleteModel();
        this.view = view;
    }

    @Override
    public void onDeleteEmgServiceSuccess(String message) {
        view.showMessage(message);
    }

    @Override
    public void onDeleteEmgServiceError(String error) {
        view.showMessage(error);
    }

    @Override
    public void onDeleteSuccess() {

    }

    @Override
    public void onDeleteError(String error) {
        view.showError(error);
    }


    public void deleteEmgService(Long id) {
        model.deleteEmgService(id, this);
    }
}
