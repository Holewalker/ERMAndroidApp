package com.svalero.ermandroidapp.contract.EmgPersonal;

import com.svalero.ermandroidapp.domain.EmgPersonal;

public interface EmgPersonalDetailsContract {

    interface Model {
        interface OnLoadEmgPersonalListener {

            void onLoadEmgPersonalDetailsSuccess(EmgPersonal emgPersonal);

            void onLoadEmgPersonalDetailsError(String message);

        }

        void loadEmgPersonalById(OnLoadEmgPersonalListener listener, Long id);
    }


    interface View {


    }

    interface Presenter {

    }
}
