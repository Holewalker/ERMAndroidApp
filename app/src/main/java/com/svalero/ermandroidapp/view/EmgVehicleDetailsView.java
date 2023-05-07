package com.svalero.ermandroidapp.view;


import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;


import com.svalero.ermandroidapp.R;
import com.svalero.ermandroidapp.contract.EmgVehicle.EmgVehicleDetailsContract;
import com.svalero.ermandroidapp.domain.EmgVehicle;
import com.svalero.ermandroidapp.presenter.EmgService.EmgVehicleDetailsPresenter;

import java.util.ArrayList;


public class EmgVehicleDetailsView extends AppCompatActivity implements EmgVehicleDetailsContract.View {

    private EmgVehicleDetailsPresenter presenter;
    private EmgVehicle emgVehicle;
    private TextView tvModel;
    private TextView tvVin;
    private TextView tvOperStatus;
    private TextView tvLat;
    private TextView tvLon;
    private TextView tvLastMaint;
    private TextView tvLocation;
    private TextView tvType;
    private TextView tvEmgServiceId;

    private long emgVehicleId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emgvehicle_details_view);
        Intent intentFrom = getIntent();
        emgVehicleId = intentFrom.getLongExtra("emgVehicleId", 0L);
        if (emgVehicleId == 0L) {
            return;
        }

        presenter = new EmgVehicleDetailsPresenter(this);
        tvModel = findViewById(R.id.emgVehicleModel);
        tvVin = findViewById(R.id.emgVehicleVin);
        tvOperStatus = findViewById(R.id.emgVehicleOperStatus);
        tvLat = findViewById(R.id.emgVehicleLat);
        tvLon = findViewById(R.id.emgVehicleLon);
        tvLastMaint = findViewById(R.id.emgVehicleLastMaintenance);
        tvLocation = findViewById(R.id.emgVehicleLocation);
        tvType = findViewById(R.id.emgVehicleType);
        tvEmgServiceId = findViewById(R.id.emgVehicleEmgServiceId);
        presenter.loadEmgVehicle(emgVehicleId);


    }

    @Override
    public void showEmgVehicle(EmgVehicle emgVehicle) {
        tvEmgServiceId.setText(String.valueOf(emgVehicle.getEmgServiceVehicle().getId()));
        tvModel.setText(emgVehicle.getModel());
        tvVin.setText(emgVehicle.getVin());
        tvOperStatus.setText(String.valueOf(emgVehicle.getOperStatus()));
        tvLat.setText(String.valueOf(emgVehicle.getLat()));
        tvLon.setText(String.valueOf(emgVehicle.getLon()));
        tvLastMaint.setText(emgVehicle.getLastMaintenance());
        tvLocation.setText(emgVehicle.getLocation());
        tvType.setText(emgVehicle.getType());

        this.emgVehicle = emgVehicle;
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}