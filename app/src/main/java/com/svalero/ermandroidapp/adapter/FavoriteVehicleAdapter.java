package com.svalero.ermandroidapp.adapter;

import static com.svalero.ermandroidapp.utils.db.Constants.DATABASE_NAME;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.svalero.ermandroidapp.R;
import com.svalero.ermandroidapp.contract.EmgVehicle.EmgVehicleDeleteContract;
import com.svalero.ermandroidapp.domain.EmgVehicle;
import com.svalero.ermandroidapp.domain.FavoriteVehicle;
import com.svalero.ermandroidapp.presenter.EmgVehicle.EmgVehicleDeletePresenter;
import com.svalero.ermandroidapp.utils.db.AppDatabase;
import com.svalero.ermandroidapp.view.EmgVehicleAddView;
import com.svalero.ermandroidapp.view.EmgVehicleDetailsView;

import java.util.List;

public class FavoriteVehicleAdapter extends RecyclerView.Adapter<FavoriteVehicleAdapter.SuperheroHolder>
        {

    private Context context;
    private List<FavoriteVehicle> emgVehicleList;
    private View snackBarView;

    public FavoriteVehicleAdapter(Context context, List<FavoriteVehicle> dataList) {
        this.context = context;
        this.emgVehicleList = dataList;
    }

    public Context getContext() {
        return context;
    }

    @Override
    public SuperheroHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.favvehicle_item, parent, false);
        return new SuperheroHolder(view);
    }

    @Override
    public void onBindViewHolder(SuperheroHolder holder, int position) {
        holder.emgVehicleType.setText(emgVehicleList.get(position).getType());
        holder.emgVehicleVin.setText(emgVehicleList.get(position).getVin());

    }

    @Override
    public int getItemCount() {
        return emgVehicleList.size();
    }


    public class SuperheroHolder extends RecyclerView.ViewHolder {
        public TextView emgVehicleVin;
        public TextView emgVehicleType;
        public Button deleteEmgVehicleButton;
        public View parentView;

        public SuperheroHolder(View view) {
            super(view);
            parentView = view;
            snackBarView = parentView;
            emgVehicleVin = view.findViewById(R.id.emgVehicle_vin);
            emgVehicleType = view.findViewById(R.id.emgVehicle_type);
            deleteEmgVehicleButton = view.findViewById(R.id.bListDelete);

            deleteEmgVehicleButton.setOnClickListener(v -> deleteEmgVehicle(getAdapterPosition()));
        }
    }


    private void deleteEmgVehicle(int position) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(R.string.are_you_sure_message)
                .setTitle(R.string.remove_emgVehicle_message)
                .setPositiveButton(R.string.yes, (dialog, id) -> {
                    final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
                    FavoriteVehicle emgVehicle = emgVehicleList.get(position);
                    db.vehicleListDao().delete(emgVehicle);
                    emgVehicleList.remove(position);
                    notifyItemRemoved(position);
                })
                .setNegativeButton("NO", (dialog, id) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

