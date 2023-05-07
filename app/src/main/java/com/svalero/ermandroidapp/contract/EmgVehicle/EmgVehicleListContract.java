package com.svalero.ermandroidapp.contract.EmgVehicle;

import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.svalero.ermandroidapp.R;
import com.svalero.ermandroidapp.domain.EmgVehicle;

import java.util.List;

public interface EmgVehicleListContract {

    interface Model {


        interface OnLoadEmgVehicleListener {

            void onLoadEmgVehicleListSuccess(List<EmgVehicle> emgVehicleList);

            void onLoadEmgVehicleListError(String message);

            void onLoadEmgVehicleListServiceSuccess(List<EmgVehicle> emgVehicleList);

            void onLoadEmgVehicleListServiceError(String message);
        }

        void loadAllEmgVehicle(OnLoadEmgVehicleListener listener);

        void loadAllEmgVehicleByServiceId(Long serviceId, OnLoadEmgVehicleListener listener);
    }


    interface View {


        public boolean onOptionsItemSelected(@NonNull MenuItem item);

        void showEmgVehicleList(List<EmgVehicle> emgVehicles);

        void showMessage(String message);
    }

    interface Presenter {

        void loadAllEmgVehicle();

        void loadAllEmgVehicleByServiceId(Long id);
    }
}
