package com.svalero.ermandroidapp.contract.EmgVehicle;

import com.svalero.ermandroidapp.domain.EmgVehicle;

import java.util.List;

public interface EmgVehicleListContract {

    interface Model {
        interface OnLoadEmgVehicleListener {

            void onLoadEmgVehicleListSuccess(List<EmgVehicle> emgVehicleList);

            void onLoadEmgVehicleListError(String message);

        }

        void loadAllEmgVehicle(OnLoadEmgVehicleListener listener);

    }


    interface View {


    }

    interface Presenter {

    }
}
