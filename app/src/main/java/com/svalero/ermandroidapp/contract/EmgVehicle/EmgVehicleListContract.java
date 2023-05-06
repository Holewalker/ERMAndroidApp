package com.svalero.ermandroidapp.contract.EmgVehicle;

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


        /*
                @Override
                public boolean onOptionsItemSelected(@NonNull MenuItem item) {
                    if (item.getItemId() == R.id.register_task) {
                        Intent intent = new Intent(this, addEmergencyVehicleView.class);
                        startActivity(intent);
                        return true;
                    } else if (item.getItemId() == R.id.view_map) {
                        Intent intent = new Intent(this, MapsActivity.class);
                        startActivity(intent);
                    }

                    return false;
                }
            */
        void showEmgVehicleList(List<EmgVehicle> emgVehicles);

        void showMessage(String message);
    }

    interface Presenter {

        void loadAllEmgVehicle();

        void loadAllEmgVehicleByServiceId(Long id);
    }
}
