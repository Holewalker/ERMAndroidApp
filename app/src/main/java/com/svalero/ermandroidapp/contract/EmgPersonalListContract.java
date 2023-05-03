package com.svalero.ermandroidapp.contract;

import com.svalero.ermandroidapp.domain.EmgPersonal;

import java.util.List;

public interface EmgPersonalListContract {

    interface Model {
        interface OnLoadEmgPersonalListener {

            void onLoadEmgPersonalListSuccess(List<EmgPersonal> emgPersonalList);

            void onLoadEmgPersonalListError(String message);

            void onLoadEmgPersonalSuccess(EmgPersonal emgPersonal);
        }

        void loadAllEmgPersonal(OnLoadEmgPersonalListener listener);

        void loadEmgPersonalById(OnLoadEmgPersonalListener listener, Long id);
    }


    interface View {


    }

    interface Presenter {

    }
}
