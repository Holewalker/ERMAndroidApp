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
import com.svalero.ermandroidapp.domain.EmgVehicle;
import com.svalero.ermandroidapp.presenter.EmgVehicle.EmgVehicleAddPresenter;
import com.svalero.ermandroidapp.presenter.EmgVehicle.EmgVehicleEditPresenter;


public class EmgVehicleAddView extends AppCompatActivity implements EmgVehicleAddContract.View {

    private EditText eLocation;
    private EditText eType;
    private Button button;
    private EmgVehicleAddPresenter emgVehicleAddPresenter;
    private EmgVehicleEditPresenter emgVehicleEditPresenter;
    EmgVehicle emgVehicleEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_emgvehicle);

        eLocation = findViewById(R.id.emgVehicleAddLocation);
        eType = findViewById(R.id.emgVehicleAddType);
        button = findViewById(R.id.emgVehicleAddRegister);

        Intent intentFrom = getIntent();
        emgVehicleEdit = (EmgVehicle) intentFrom.getSerializableExtra("editEmgVehicle");
        Log.i("EmgVehicleAddView", "onCreate - Intent EmgVehicle: " + emgVehicleEdit);

        if (emgVehicleEdit != null) {
            eLocation.setText(emgVehicleEdit.getLocation());
            eType.setText(emgVehicleEdit.getType());
            button.setText(R.string.editButton);
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
        String location = eLocation.getText().toString();
        String type = eType.getText().toString();
///TODO
        EmgVehicle emgVehicle = new EmgVehicle(location, type);
        if (emgVehicleEdit != null) {
            emgVehicleEditPresenter.emgVehicleEdit(emgVehicleEdit.getId(), emgVehicle);
        } else {
            emgVehicleAddPresenter.addEmgVehicle(emgVehicle);
        }
    }
}