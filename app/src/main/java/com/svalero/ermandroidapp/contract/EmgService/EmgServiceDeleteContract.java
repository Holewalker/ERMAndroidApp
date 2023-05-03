package com.svalero.ermandroidapp.contract.EmgService;

public interface EmgServiceDeleteContract {

    interface Model {
        interface OnDeleteEmgServiceListener {

            void onDeleteSuccess();

            void onDeleteError(String message);

        }

        void deleteEmgService(Long id, OnDeleteEmgServiceListener listener);
    }


    interface View {


        void showError(String errorMessage);

        void showMessage(String message);
    }

    interface Presenter {

    }
}
