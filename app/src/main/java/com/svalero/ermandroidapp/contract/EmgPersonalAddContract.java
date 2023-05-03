package com.svalero.ermandroidapp.contract;

import com.svalero.ermandroidapp.domain.EmgPersonal;

public interface EmgPersonalAddContract {

    interface Model {
        interface OnAddEmgPersonalListener {

            void onAddSuccess(EmgPersonal emgPersonal);

            void onAddError(String message);

        }

        void addEmgPersonal(EmgPersonal emgPersonal, OnAddEmgPersonalListener listener);
    }


    interface View {


    }

    interface Presenter {

    }
}
