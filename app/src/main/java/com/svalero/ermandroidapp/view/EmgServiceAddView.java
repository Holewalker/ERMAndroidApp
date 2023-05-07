package com.svalero.ermandroidapp.view;

import static com.svalero.storeapp.util.Constants.DATABASE_NAME;

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


public class EmgServiceAddView extends AppCompatActivity implements EmgServiceAddContract.View {

    private EditText eLocation;
    private EditText etDescription;
    private EditText etPrice;
    private EditText eType;
    private Button button;
    private EmgServiceAddPresenter emgServiceAddPresenter;
    // private EditEmgServicePresenter editEmgServicePresenter;
    EmgService emgServiceEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_emgService_view);

        /*
        final StoreAppDatabase db = Room.databaseBuilder(this, StoreAppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
        persistData = new PersistData(0, "", "", "",false);
        try{
            persistData = db.getPersistDataDAO().getPersistData();
        }   catch (SQLiteConstraintException sce) {
            Log.i("EmgServiceAddView" , "onCreate - Error");
            sce.printStackTrace();
        } finally {
            db.close();
        }*/

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
    }


    @Override
    public void showError(String error) {
        Snackbar.make(((EditText) findViewById(R.id.emgServiceAddName)), error,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(((EditText) findViewById(R.id.emgServiceAddName)), message,
                BaseTransientBottomBar.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void register(View view) {
        String location = eLocation.getText().toString();
        String type = eType.getText().toString();

       /* if (emgServiceEdit != null) {
            EmgService emgService = new EmgService(emgServiceEdit.getId(), location, description, price, type);
            editEmgServicePresenter.editEmgService(emgService, persistData.getToken());
        } else {*/

        EmgService emgService = new EmgService(location, type);
        emgServiceAddPresenter.addEmgService(emgService);
        // }
    }
}