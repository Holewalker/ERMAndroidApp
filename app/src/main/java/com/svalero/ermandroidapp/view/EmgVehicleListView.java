package com.svalero.ermandroidapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.ermandroidapp.R;
import com.svalero.ermandroidapp.adapter.EmgVehicleAdapter;
import com.svalero.ermandroidapp.contract.EmgVehicle.EmgVehicleListContract;
import com.svalero.ermandroidapp.domain.EmgVehicle;
import com.svalero.ermandroidapp.presenter.EmgVehicle.EmgVehicleListPresenter;

import java.util.ArrayList;
import java.util.List;

public class EmgVehicleListView extends AppCompatActivity implements EmgVehicleListContract.View {
    private List<EmgVehicle> emgVehicleList;
    private EmgVehicleAdapter adapter;
    private EmgVehicleListPresenter presenter;
    private Long serviceId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo
        setContentView(R.layout.activity_list_emgvehicles);
        Intent intentFrom = getIntent();
        serviceId = intentFrom.getLongExtra("id", 0L);
        presenter = new EmgVehicleListPresenter(this);
        initializeRecyclerView();
    }

    private void initializeRecyclerView() {
        emgVehicleList = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.rvListVehicles);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new EmgVehicleAdapter(this, emgVehicleList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadAllEmgVehicleByServiceId(serviceId);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return true;
    }

    /*
        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if (item.getItemId() == R.id.register_task) {
                Intent intent = new Intent(this, addEmergencyVehicleView.class);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.view_map) {
                Intent intent = new Intent(this, MapsActivity.class);
                startActivity(intent);
            }

            return false;
        }
    */
    @Override
    public void showEmgVehicleList(List<EmgVehicle> emgVehicles) {
        this.emgVehicleList.clear();
        this.emgVehicleList.addAll(emgVehicles);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

    public void returnNav(View view) {
        Intent intent = new Intent(EmgVehicleListView.this, MainActivity.class);
        startActivity(intent);
    }
}
