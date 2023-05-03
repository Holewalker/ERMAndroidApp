package com.svalero.ermandroidapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.svalero.ermandroidapp.R;
import com.svalero.ermandroidapp.contract.EmgService.EmgServiceDeleteContract;
import com.svalero.ermandroidapp.domain.EmgService;


import java.util.List;

public class EmgServiceAdapter extends RecyclerView.Adapter<EmgServiceAdapter.SuperheroHolder>
        implements EmgServiceDeleteContract.View {

    private Context context;
    private List<EmgService> emgServiceList;
    private View snackBarView;
    //private EmgServiceDeletePresenter presenter;

    public EmgServiceAdapter(Context context, List<EmgService> dataList) {
        this.context = context;
        this.emgServiceList = dataList;
        //presenter = new DeleteEmgServicePresenter(this);
    }

    public Context getContext() {
        return context;
    }

    @Override
    public SuperheroHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.emgService_item, parent, false);
        return new SuperheroHolder(view);
    }

    @Override
    public void onBindViewHolder(SuperheroHolder holder, int position) {
        holder.emgServiceLocation.setText(emgServiceList.get(position).getLocation());
        holder.emgServiceType.setText(emgServiceList.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return emgServiceList.size();
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
        public TextView emgServiceLocation;
        public TextView emgServiceType;
        public Button seeDetailsButton;
        public Button deleteEmgServiceButton;
        public View parentView;

        public SuperheroHolder(View view) {
            super(view);
            parentView = view;
            snackBarView = parentView;

            emgServiceLocation = view.findViewById(R.id.emgService_location);
            emgServiceType = view.findViewById(R.id.emgService_type);

            seeDetailsButton = view.findViewById(R.id.see_details_button);
            deleteEmgServiceButton = view.findViewById(R.id.delete_emgService_button);

            // Ver detalles de la tarea
            //  seeDetailsButton.setOnClickListener(v -> seeDetails(getAdapterPosition()));
            // Eliminar tarea
            //  deleteEmgServiceButton.setOnClickListener(v -> deleteEmgService(getAdapterPosition()));
        }
    }

//todo
/*    private void seeDetails(int position) {
        EmgService emgService = emgServiceList.get(position);

        Intent intent = new Intent(context, EmgServiceDetailsView.class);
        intent.putExtra("name", emgService.getName());
        context.startActivity(intent);
    }
    */

//todo
    /*
    private void deleteEmgService(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(R.string.are_you_sure_message)
                .setTitle(R.string.remove_emgService_message)
                .setPositiveButton(R.string.yes, (dialog, id) -> {
                    EmgService emgService = emgServiceList.get(position);
                    presenter.deleteEmgService(emgService.getId());

                    emgServiceList.remove(position);
                    notifyItemRemoved(position);
                })
                .setNegativeButton(R.string.no, (dialog, id) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }*/
}

