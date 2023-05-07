package com.svalero.ermandroidapp.contract.EmgService;

public interface EmgServiceDeleteContract {

    interface Model {
        interface OnDeleteEmgServiceListener {

            void onDeleteEmgServiceSuccess(String message);

            void onDeleteEmgServiceError(String error);

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
        void deleteEmgService(Long id);
    }
}
