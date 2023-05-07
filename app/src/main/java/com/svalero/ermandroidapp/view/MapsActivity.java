package com.svalero.ermandroidapp.view;

import static com.mapbox.core.constants.Constants.PRECISION_6;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mapbox.api.directions.v5.DirectionsCriteria;
import com.mapbox.api.directions.v5.MapboxDirections;
import com.mapbox.api.directions.v5.models.DirectionsResponse;
import com.mapbox.api.directions.v5.models.DirectionsRoute;
import com.mapbox.api.directions.v5.models.LegStep;
import com.mapbox.api.directions.v5.models.RouteLeg;
import com.mapbox.api.directions.v5.models.RouteOptions;
import com.mapbox.core.constants.Constants;
import com.mapbox.geojson.LineString;
import com.mapbox.geojson.Point;
import com.mapbox.maps.CameraOptions;
import com.mapbox.maps.MapView;
import com.mapbox.maps.extension.style.layers.LayerUtils;
import com.mapbox.maps.extension.style.layers.generated.LineLayer;
import com.mapbox.maps.extension.style.sources.SourceUtils;
import com.mapbox.maps.extension.style.sources.generated.GeoJsonSource;
import com.mapbox.maps.plugin.annotation.AnnotationConfig;
import com.mapbox.maps.plugin.annotation.AnnotationPlugin;
import com.mapbox.maps.plugin.annotation.AnnotationPluginImplKt;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManager;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationManagerKt;
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions;
import com.svalero.ermandroidapp.R;
import com.svalero.ermandroidapp.contract.EmgVehicle.EmgVehicleListContract;
import com.svalero.ermandroidapp.domain.EmgVehicle;
import com.svalero.ermandroidapp.presenter.EmgVehicle.EmgVehicleListPresenter;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends AppCompatActivity implements EmgVehicleListContract.View,
        Callback<DirectionsResponse> {

    private MapView mapView;
    private PointAnnotationManager pointAnnotationManager;
    private EmgVehicleListPresenter emgVehicleListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);

        mapView = findViewById(R.id.mapView);
        initializePointManager();

        emgVehicleListPresenter = new EmgVehicleListPresenter(this);
        emgVehicleListPresenter.loadAllEmgVehicle();
    }

    private void initializePointManager() {
        AnnotationPlugin annotationPlugin = AnnotationPluginImplKt.getAnnotations(mapView);
        AnnotationConfig annotationConfig = new AnnotationConfig();
        pointAnnotationManager = PointAnnotationManagerKt.createPointAnnotationManager(annotationPlugin, annotationConfig);
    }

    private void addMarker(Point point, String title) {
        PointAnnotationOptions pointAnnotationOptions = new PointAnnotationOptions()
                .withPoint(point)
                .withTextField(title)
                .withIconImage(BitmapFactory.decodeResource(getResources(), R.mipmap.red_marker));
        pointAnnotationManager.create(pointAnnotationOptions);
    }

    private void setCameraPosition(Point point) {
        CameraOptions cameraPosition = new CameraOptions.Builder()
                .center(point)
                .pitch(0.0)
                .zoom(13.5)
                .bearing(-17.6)
                .build();
        mapView.getMapboxMap().setCamera(cameraPosition);
    }

    private void addEmgVehiclesToMap(List<EmgVehicle> emgVehicles) {
        for (EmgVehicle emgVehicle : emgVehicles) {
            Point point = Point.fromLngLat(emgVehicle.getLon(), emgVehicle.getLat());
            addMarker(point, emgVehicle.getVin());
        }

        // FIXME
        // Point origin = Point.fromLngLat(emgVehicles.get(0).getLon(), emgVehicles.get(0).getLat());
        // Point destination = Point.fromLngLat(emgVehicles.get(1).getLon(), emgVehicles.get(1).getLat());
        // calculateRoute(origin, destination);
    }

    @Override
    public void showEmgVehicleList(List<EmgVehicle> emgVehicles) {
        addEmgVehiclesToMap(emgVehicles);
        setCameraPosition(Point.fromLngLat(emgVehicles.get(0).getLon(), emgVehicles.get(0).getLat()));
    }


    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
/*
    private void calculateRoute(Point origin, Point destination) {
        RouteOptions routeOptions = RouteOptions.builder()
                .baseUrl(Constants.BASE_API_URL)
                .user(Constants.MAPBOX_USER)
                .profile(DirectionsCriteria.PROFILE_WALKING)
                .steps(true)
                .coordinatesList(List.of(origin, destination))
                .build();
        MapboxDirections directions = MapboxDirections.builder()
                .routeOptions(routeOptions)
                .accessToken(getString(R.string.mapbox_access_token))
                .build();
        directions.enqueueCall(this);
    }*/

   /* @Override
    public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
        DirectionsRoute mainRoute = response.body().routes().get(0);
        Log.d("ROUTELEGS", String.valueOf(mainRoute.legs().size()));
        for (RouteLeg routeLeg: mainRoute.legs()) {
            Log.d("LEGS", String.valueOf(routeLeg.steps().size()));
            for (LegStep legStep : routeLeg.steps()) {
                Log.d("STEP", legStep.name() + " " + legStep.speedLimitSign() + " " + legStep);
            }
        }
        mapView.getMapboxMap().getStyle(style -> {
            LineString routeLine = LineString.fromPolyline(mainRoute.geometry(), PRECISION_6);

            GeoJsonSource routeSource = new GeoJsonSource.Builder("trace-source")
                    .geometry(routeLine)
                    .build();
            LineLayer routeLayer = new LineLayer("trace-layer", "trace-source")
                    .lineWidth(7.f)
                    .lineColor(Color.BLUE)
                    .lineOpacity(1f);
            SourceUtils.addSource(style, routeSource);
            LayerUtils.addLayer(style, routeLayer);
        });
    }*/

    @Override
    public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {

    }

    @Override
    public void onFailure(Call<DirectionsResponse> call, Throwable t) {
        Log.e("CalculateRoute", "Fallo al invocar a la API de Mapbox", t);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    public void returnNav(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}