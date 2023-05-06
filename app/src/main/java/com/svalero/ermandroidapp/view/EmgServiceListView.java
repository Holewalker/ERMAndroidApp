package com.svalero.ermandroidapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.ermandroidapp.R;
import com.svalero.ermandroidapp.adapter.EmgServiceAdapter;
import com.svalero.ermandroidapp.contract.EmgService.EmgServiceListContract;
import com.svalero.ermandroidapp.domain.EmgService;
import com.svalero.ermandroidapp.presenter.EmgService.EmgServiceListPresenter;

import java.util.ArrayList;
import java.util.List;

public class EmgServiceListView extends AppCompatActivity implements EmgServiceListContract.View {
    private List<EmgService> emgServiceList;
    private EmgServiceAdapter adapter;
    private EmgServiceListPresenter presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo
        setContentView(R.layout.activity_list_emgservices);
        presenter = new EmgServiceListPresenter(this);
        initializeRecyclerView();
    }

    private void initializeRecyclerView() {
        emgServiceList = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.rvListServices);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new EmgServiceAdapter(this, emgServiceList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.loadAllEmgService();
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
            Intent intent = new Intent(this, addEmergencyServiceView.class);
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
    public void showEmgServiceList(List<EmgService> emgServices) {
        this.emgServiceList.clear();
        this.emgServiceList.addAll(emgServices);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }
    public void returnNav(View view) {
        Intent intent = new Intent(EmgServiceListView.this, MainActivity.class);
        startActivity(intent);
    }
}
