package com.svalero.ermandroidapp.contract;

import com.svalero.ermandroidapp.domain.EmgPersonal;

public interface EmgPersonalEditContract {

    interface Model {
        interface OnEditEmgPersonalListener {

            void onEditSuccess(EmgPersonal emgPersonal);

            void onEditError(String message);

        }

        void editEmgPersonal(Long id, EmgPersonal emgPersonal, OnEditEmgPersonalListener listener);
    }


    interface View {


    }

    interface Presenter {

    }
}
