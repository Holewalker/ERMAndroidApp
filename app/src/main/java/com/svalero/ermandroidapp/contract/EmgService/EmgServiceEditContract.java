package com.svalero.ermandroidapp.contract.EmgService;

import com.svalero.ermandroidapp.domain.EmgService;

public interface EmgServiceEditContract {

    interface Model {
        interface OnEditEmgServiceListener {

            void onEditSuccess(EmgService emgService);

            void onEditError(String message);

        }

        void editEmgService(Long id, EmgService emgService, OnEditEmgServiceListener listener);
    }


    interface View {


    }

    interface Presenter {

    }
}
