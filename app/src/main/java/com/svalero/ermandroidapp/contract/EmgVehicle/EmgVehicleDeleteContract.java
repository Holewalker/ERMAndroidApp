package com.svalero.ermandroidapp.contract.EmgVehicle;

public interface EmgVehicleDeleteContract {

    interface Model {
        interface OnDeleteEmgVehicleListener {

            void onDeleteSuccess();

            void onDeleteError(String message);

        }

        void deleteEmgVehicle(Long id, OnDeleteEmgVehicleListener listener);
    }


    interface View {


    }

    interface Presenter {

    }
}
