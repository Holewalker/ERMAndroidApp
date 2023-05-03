package com.svalero.ermandroidapp.contract.EmgPersonal;

import com.svalero.ermandroidapp.domain.EmgPersonal;

import java.util.List;

public interface EmgPersonalListContract {

    interface Model {
        interface OnLoadEmgPersonalListener {

            void onLoadEmgPersonalListSuccess(List<EmgPersonal> emgPersonalList);

            void onLoadEmgPersonalListError(String message);

        }

        void loadAllEmgPersonal(OnLoadEmgPersonalListener listener);

    }


    interface View {


    }

    interface Presenter {

    }
}
