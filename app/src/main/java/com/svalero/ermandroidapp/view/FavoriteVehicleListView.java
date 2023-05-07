package com.svalero.ermandroidapp.view;

import static com.svalero.ermandroidapp.utils.db.Constants.DATABASE_NAME;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.svalero.ermandroidapp.R;
import com.svalero.ermandroidapp.adapter.FavoriteVehicleAdapter;
import com.svalero.ermandroidapp.domain.FavoriteVehicle;

import com.svalero.ermandroidapp.utils.db.AppDatabase;

import java.util.ArrayList;
import java.util.List;

public class FavoriteVehicleListView extends AppCompatActivity {
    private List<FavoriteVehicle> favoriteVehicleList;
    private FavoriteVehicleAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_favvehicles);

        initializeRecyclerView();
    }

    private void initializeRecyclerView() {
        favoriteVehicleList = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.rvListVehicles);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FavoriteVehicleAdapter(this, favoriteVehicleList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        favoriteVehicleList.clear();
        final AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
        favoriteVehicleList.addAll(db.vehicleListDao().getAll());
        adapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return true;
    }


    public void returnNav(View view) {
        Intent intent = new Intent(FavoriteVehicleListView.this, MainActivity.class);
        startActivity(intent);
    }
}
