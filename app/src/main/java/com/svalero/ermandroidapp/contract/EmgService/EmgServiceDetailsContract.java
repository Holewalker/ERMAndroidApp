package com.svalero.ermandroidapp.contract.EmgService;

import com.svalero.ermandroidapp.domain.EmgService;

public interface EmgServiceDetailsContract {

    interface Model {
        interface OnLoadEmgServiceListener {

            void onLoadEmgServiceDetailsSuccess(EmgService emgService);

            void onLoadEmgServiceDetailsError(String message);

        }

        void loadEmgServiceById(OnLoadEmgServiceListener listener, Long id);
    }


    interface View {


    }

    interface Presenter {

    }
}
