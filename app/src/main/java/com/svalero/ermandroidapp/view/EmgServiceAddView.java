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
import com.svalero.ermandroidapp.contract.EmgService.EmgServiceAddContract;
import com.svalero.ermandroidapp.domain.EmgService;
import com.svalero.ermandroidapp.presenter.EmgService.EmgServiceAddPresenter;
import com.svalero.ermandroidapp.presenter.EmgService.EmgServiceEditPresenter;


public class EmgServiceAddView extends AppCompatActivity implements EmgServiceAddContract.View {

    private EditText eLocation;
    private EditText eType;
    private Button button;
    private EmgServiceAddPresenter emgServiceAddPresenter;
    private EmgServiceEditPresenter emgServiceEditPresenter;
    EmgService emgServiceEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_emgservice);

        eLocation = findViewById(R.id.emgServiceAddLocation);
        eType = findViewById(R.id.emgServiceAddType);
        button = findViewById(R.id.emgServiceAddRegister);

        Intent intentFrom = getIntent();
        emgServiceEdit = (EmgService) intentFrom.getSerializableExtra("editEmgService");
        Log.i("EmgServiceAddView", "onCreate - Intent EmgService: " + emgServiceEdit);

        if (emgServiceEdit != null) {
            eLocation.setText(emgServiceEdit.getLocation());
            eType.setText(emgServiceEdit.getType());
            button.setText(R.string.editButton);
        }
        emgServiceAddPresenter = new EmgServiceAddPresenter(this);
        emgServiceEditPresenter = new EmgServiceEditPresenter(this);

    }


    @Override
    public void showError(String error) {
        Snackbar.make(((EditText) findViewById(R.id.emgServiceAddLocation)), error,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(((EditText) findViewById(R.id.emgServiceAddLocation)), message,
                BaseTransientBottomBar.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void register(View view) {
        String location = eLocation.getText().toString();
        String type = eType.getText().toString();

        EmgService emgService = new EmgService(location, type);
        if (emgServiceEdit != null) {
            emgServiceEditPresenter.emgServiceEdit(emgServiceEdit.getId(), emgService);
        } else {
            emgServiceAddPresenter.addEmgService(emgService);
        }
        Intent intent = new Intent(this, EmgServiceListView.class);
        startActivity(intent);
    }
    public void returnNav(View view) {
        Intent intent = new Intent(this, EmgServiceListView.class);
        startActivity(intent);
    }
}