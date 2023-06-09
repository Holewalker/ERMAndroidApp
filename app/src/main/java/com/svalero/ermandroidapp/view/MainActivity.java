package com.svalero.ermandroidapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.svalero.ermandroidapp.R;
import com.svalero.ermandroidapp.model.EmgService.EmgServiceListModel;
import com.svalero.ermandroidapp.utils.SessionUtil;

public class MainActivity extends AppCompatActivity {
    private SessionUtil session;//global variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session = new SessionUtil(MainActivity.this);

        TextView textViewUsername = findViewById(R.id.username);
        textViewUsername.setText(session.getUserName());
    }

/*
    public void listActivitiesNav(View view) {
        Intent intent = new Intent(MainActivity.this, ListActivities.class);
        startActivity(intent);
    }

    public void addActivityNav(View view) {
        Intent intent = new Intent(MainActivity.this, AddActivity.class);
        startActivity(intent);
    }



    public void addPlaceNav(View view) {
        Intent intent = new Intent(MainActivity.this, AddPlace.class);
        startActivity(intent);
    }

    public void listUsersNav(View view) {
        Intent intent = new Intent(MainActivity.this, ListUsers.class);
        startActivity(intent);
    }

    public void logoutNav(View view) {
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);
    }


    public void share(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey, you should try this app!");
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }

 */

    public void listEmgServices(View view) {
        Intent intent = new Intent(MainActivity.this, EmgServiceListView.class);
        startActivity(intent);
    }
    public void listFavVehicles(View view) {
        Intent intent = new Intent(MainActivity.this, FavoriteVehicleListView.class);
        startActivity(intent);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void returnNav(View view) {
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);
    }
    /*
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuActivities) {
            Intent intent = new Intent(this, ListActivities.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.menuPlaces) {
            Intent intent = new Intent(this, ListPlaces.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.menuUsers) {
            Intent intent = new Intent(this, ListUsers.class);
            startActivity(intent);
            return true;


        }
        return false;
    }
         */
}


