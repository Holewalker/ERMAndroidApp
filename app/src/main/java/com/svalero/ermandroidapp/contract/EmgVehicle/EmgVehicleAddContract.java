package com.svalero.ermandroidapp.contract.EmgVehicle;

import com.svalero.ermandroidapp.domain.EmgVehicle;

public interface EmgVehicleAddContract {

    interface Model {
        interface OnAddEmgVehicleListener {

            void onAddSuccess(EmgVehicle emgVehicle);

            void onAddError(String message);

        }

        void addEmgVehicle(EmgVehicle emgVehicle, OnAddEmgVehicleListener listener);
    }


    interface View {


    }

    interface Presenter {

    }
}
