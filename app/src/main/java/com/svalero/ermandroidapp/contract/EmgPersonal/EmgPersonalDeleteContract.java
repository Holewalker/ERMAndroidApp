package com.svalero.ermandroidapp.contract.EmgPersonal;

import com.svalero.ermandroidapp.domain.EmgPersonal;

public interface EmgPersonalDeleteContract {

    interface Model {
        interface OnDeleteEmgPersonalListener {

            void onDeleteSuccess();

            void onDeleteError(String message);

        }

        void deleteEmgPersonal(Long id, OnDeleteEmgPersonalListener listener);
    }


    interface View {


    }

    interface Presenter {

    }
}
