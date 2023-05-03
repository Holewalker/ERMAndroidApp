package com.svalero.ermandroidapp.contract.EmgService;

import com.svalero.ermandroidapp.domain.EmgService;

import java.util.List;

public interface EmgServiceListContract {

    interface Model {
        interface OnLoadEmgServiceListener {

            void onLoadEmgServiceListSuccess(List<EmgService> emgServiceList);

            void onLoadEmgServiceListError(String message);

        }

        void loadAllEmgService(OnLoadEmgServiceListener listener);

    }


    interface View {


    }

    interface Presenter {

    }
}
