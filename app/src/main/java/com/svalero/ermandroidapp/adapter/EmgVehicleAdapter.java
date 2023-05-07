package com.svalero.ermandroidapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.svalero.ermandroidapp.R;
import com.svalero.ermandroidapp.contract.EmgVehicle.EmgVehicleDeleteContract;
import com.svalero.ermandroidapp.domain.EmgService;
import com.svalero.ermandroidapp.domain.EmgVehicle;
import com.svalero.ermandroidapp.presenter.EmgVehicle.DeleteEmgVehiclePresenter;
import com.svalero.ermandroidapp.view.EmgServiceAddView;
import com.svalero.ermandroidapp.view.EmgVehicleAddView;

import java.util.List;

public class EmgVehicleAdapter extends RecyclerView.Adapter<EmgVehicleAdapter.SuperheroHolder>
        implements EmgVehicleDeleteContract.View {

    private Context context;
    private List<EmgVehicle> emgVehicleList;
    private View snackBarView;
    private DeleteEmgVehiclePresenter presenter;

    public EmgVehicleAdapter(Context context, List<EmgVehicle> dataList) {
        this.context = context;
        this.emgVehicleList = dataList;
        presenter = new DeleteEmgVehiclePresenter(this);
    }

    public Context getContext() {
        return context;
    }

    @Override
    public SuperheroHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.emgvehicle_item, parent, false);
        return new SuperheroHolder(view);
    }

    @Override
    public void onBindViewHolder(SuperheroHolder holder, int position) {
        holder.emgVehicleLocation.setText(emgVehicleList.get(position).getLocation());
        holder.emgVehicleType.setText(emgVehicleList.get(position).getType());
        holder.emgVehicleModel.setText(emgVehicleList.get(position).getModel());
        holder.emgVehicleVin.setText(emgVehicleList.get(position).getVin());

    }

    @Override
    public int getItemCount() {
        return emgVehicleList.size();
    }

    @Override
    public void showError(String errorMessage) {
        Snackbar.make(snackBarView, errorMessage,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(snackBarView, message,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    public class SuperheroHolder extends RecyclerView.ViewHolder {
        public TextView emgVehicleModel;
        public TextView emgVehicleVin;
        public TextView emgVehicleType;
        public TextView emgVehicleLocation;
        public Button seeDetailsButton;
        public Button viewMapButton;
        public Button editEmgVehicleButton;
        public Button deleteEmgVehicleButton;
        public View parentView;

        public SuperheroHolder(View view) {
            super(view);
            parentView = view;
            snackBarView = parentView;
            emgVehicleModel = view.findViewById(R.id.emgVehicle_model);
            emgVehicleVin = view.findViewById(R.id.emgVehicle_vin);
            emgVehicleType = view.findViewById(R.id.emgVehicle_type);
            emgVehicleLocation = view.findViewById(R.id.emgVehicle_location);


            seeDetailsButton = view.findViewById(R.id.bListDetails);
            viewMapButton = view.findViewById(R.id.bViewMap);
            editEmgVehicleButton = view.findViewById(R.id.bListEdit);
            deleteEmgVehicleButton = view.findViewById(R.id.bListDelete);

            // Ver detalles
            seeDetailsButton.setOnClickListener(v -> seeDetails(getAdapterPosition()));
            editEmgVehicleButton.setOnClickListener(v -> editEmgVehicle(getAdapterPosition()));

            deleteEmgVehicleButton.setOnClickListener(v -> deleteEmgVehicle(getAdapterPosition()));
        }
    }

    //todo
    private void seeDetails(int position) {
        EmgVehicle emgVehicle = emgVehicleList.get(position);

       // Intent intent = new Intent(context, EmgVehicleDetailsView.class);
       // intent.putExtra("id", emgVehicle.getId());
     //   context.startActivity(intent);
    }

    private void editEmgVehicle(int adapterPosition){
        EmgVehicle emgVehicle = emgVehicleList.get(adapterPosition);
        Intent intent = new Intent(context, EmgVehicleAddView.class);
        intent.putExtra("editEmgVehicle", emgVehicle);
        context.startActivity(intent);

    }

    private void deleteEmgVehicle(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(R.string.are_you_sure_message)
                .setTitle(R.string.remove_emgVehicle_message)
                .setPositiveButton(R.string.yes, (dialog, id) -> {
                    EmgVehicle emgVehicle = emgVehicleList.get(position);
                    presenter.deleteEmgVehicle(emgVehicle.getId());

                    emgVehicleList.remove(position);
                    notifyItemRemoved(position);
                })
                .setNegativeButton("NO", (dialog, id) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

