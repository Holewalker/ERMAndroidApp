package com.svalero.ermandroidapp.contract.EmgService;

import com.svalero.ermandroidapp.domain.EmgService;

public interface EmgServiceAddContract {

    interface Model {
        interface OnAddEmgServiceListener {

            void onAddSuccess(EmgService emgService);

            void onAddError(String message);

        }

        void addEmgService(EmgService emgService, OnAddEmgServiceListener listener);
    }


    interface View {


    }

    interface Presenter {

    }
}
