package com.svalero.ermandroidapp.contract.EmgVehicle;

import com.svalero.ermandroidapp.domain.EmgVehicle;

public interface EmgVehicleDetailsContract {

    interface Model {
        interface OnLoadEmgVehicleListener {

            void onLoadEmgVehicleDetailsSuccess(EmgVehicle emgVehicle);

            void onLoadEmgVehicleDetailsError(String message);

        }

        void loadEmgVehicleById(OnLoadEmgVehicleListener listener, Long id);
    }


    interface View {


    }

    interface Presenter {

    }
}
