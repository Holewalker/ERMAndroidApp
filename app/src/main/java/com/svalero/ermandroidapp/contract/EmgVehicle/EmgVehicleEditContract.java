package com.svalero.ermandroidapp.contract.EmgVehicle;

import com.svalero.ermandroidapp.domain.EmgVehicle;

public interface EmgVehicleEditContract {

    interface Model {
        interface OnEditEmgVehicleListener {

            void onEditSuccess(EmgVehicle emgVehicle);

            void onEditError(String message);

        }

        void editEmgVehicle(Long id, EmgVehicle emgVehicle, OnEditEmgVehicleListener listener);
    }


    interface View {


    }

    interface Presenter {

        void emgVehicleEdit(Long id, EmgVehicle EmgVehicle);
    }
}
