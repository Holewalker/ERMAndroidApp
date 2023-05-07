package com.svalero.ermandroidapp.contract.EmgVehicle;

import com.svalero.ermandroidapp.domain.EmgVehicle;

import java.util.List;

public interface EmgVehicleDetailsContract {

    interface Model {
        interface OnLoadEmgVehicleListener {

            void onLoadEmgVehicleDetailsSuccess(EmgVehicle emgVehicle);

            void onLoadEmgVehicleDetailsError(String message);

        }

        void loadEmgVehicleById(Long id, OnLoadEmgVehicleListener listener);
    }


    interface View {

        public void showMessage(String message);

        void showEmgVehicle(EmgVehicle emgVehicle);
    }

    interface Presenter {

        void loadEmgVehicle(Long id);
    }
}
