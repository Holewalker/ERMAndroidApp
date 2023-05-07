package com.svalero.ermandroidapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.svalero.ermandroidapp.R;
import com.svalero.ermandroidapp.contract.EmgVehicle.EmgVehicleAddContract;
import com.svalero.ermandroidapp.domain.EmgService;
import com.svalero.ermandroidapp.domain.EmgVehicle;
import com.svalero.ermandroidapp.presenter.EmgVehicle.EmgVehicleAddPresenter;
import com.svalero.ermandroidapp.presenter.EmgVehicle.EmgVehicleEditPresenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class EmgVehicleAddView extends AppCompatActivity implements EmgVehicleAddContract.View {

    private EditText etEmgServiceId;
    private EditText etModel;
    private EditText etVin;
    private EditText etOperStatus;
    private EditText etLat;
    private EditText etLon;
    private EditText etLastMaint;
    private EditText etLocation;
    private EditText etType;
    private Button button;
    private EmgVehicleAddPresenter emgVehicleAddPresenter;
    private EmgVehicleEditPresenter emgVehicleEditPresenter;
    EmgVehicle emgVehicleEdit;
    EmgService currentEmgService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_emgvehicle);
        etEmgServiceId = findViewById(R.id.emgVehicleAddEmgServiceId);
        etModel = findViewById(R.id.emgVehicleAddModel);
        etVin = findViewById(R.id.emgVehicleAddVin);
        etOperStatus = findViewById(R.id.emgVehicleAddOperStatus);
        etLat = findViewById(R.id.emgVehicleAddLat);
        etLon = findViewById(R.id.emgVehicleAddLon);
        etLastMaint = findViewById(R.id.emgVehicleAddLastMaintenance);
        etLocation = findViewById(R.id.emgVehicleAddLocation);
        etType = findViewById(R.id.emgVehicleAddType);
        button = findViewById(R.id.emgVehicleAddRegister);

        Intent intentFrom = getIntent();

        emgVehicleEdit = (EmgVehicle) intentFrom.getSerializableExtra("editEmgVehicle");

        Log.i("EmgVehicleAddView", "onCreate - Intent EmgVehicle: " + emgVehicleEdit);

        if (emgVehicleEdit != null) {
            etEmgServiceId.setText(String.valueOf(emgVehicleEdit.getEmgServiceVehicle().getId()));
            etModel.setText(emgVehicleEdit.getModel());
            etVin.setText(emgVehicleEdit.getVin());
            etOperStatus.setText(String.valueOf(emgVehicleEdit.getOperStatus()));
            etLat.setText(String.valueOf(emgVehicleEdit.getLat()));
            etLon.setText(String.valueOf(emgVehicleEdit.getLon()));
            etLastMaint.setText(emgVehicleEdit.getLastMaintenance());
            etLocation.setText(emgVehicleEdit.getLocation());
            etType.setText(emgVehicleEdit.getType());
            button.setText(R.string.editButton);
        } else {
            currentEmgService = (EmgService) intentFrom.getSerializableExtra("currentEmgService");
            etEmgServiceId.setText(String.valueOf(currentEmgService.getId()));
        }
        emgVehicleAddPresenter = new EmgVehicleAddPresenter(this);
        emgVehicleEditPresenter = new EmgVehicleEditPresenter(this);

    }


    @Override
    public void showError(String error) {
        Snackbar.make(((EditText) findViewById(R.id.emgVehicleAddLocation)), error,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(((EditText) findViewById(R.id.emgVehicleAddLocation)), message,
                BaseTransientBottomBar.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void register(View view) {
        String model = etModel.getText().toString();
        String vin = etVin.getText().toString();
        int operStatus = Integer.parseInt(etOperStatus.getText().toString());
        double lat = Double.parseDouble(etLat.getText().toString());
        double lon = Double.parseDouble(etLon.getText().toString());
        String lastMaint = dateFormat(etLastMaint.getText().toString());
        String location = etLocation.getText().toString();
        String type = etType.getText().toString();

        EmgVehicle emgVehicle = new EmgVehicle(currentEmgService.getId(), model, vin, type, operStatus, location, lat, lon, lastMaint);
        if (emgVehicleEdit != null) {
            emgVehicleEditPresenter.emgVehicleEdit(emgVehicleEdit.getId(), emgVehicle);
        } else {
            emgVehicleAddPresenter.addEmgVehicle(emgVehicle);
        }
        Intent intent = new Intent(this, EmgVehicleListView.class);
        intent.putExtra("id", currentEmgService.getId());
        intent.putExtra("currentEmgService", currentEmgService);
        startActivity(intent);
    }


    private String dateFormat(String originalDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = format.parse(originalDate);
            return format.format(date);
        } catch (ParseException e) {
            Date date = new Date();
            return format.format(date.toString());
        }

    }
    public void returnNav(View view) {
        Intent intent = new Intent(this, EmgServiceListView.class);
        startActivity(intent);
    }
}