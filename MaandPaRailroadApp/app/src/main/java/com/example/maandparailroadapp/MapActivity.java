package com.example.maandparailroadapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationClient;
    private LatLng companyLocation = new LatLng(39.8083, -76.475); // Replace with your coordinates


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
// Set up zoom in button
        ImageButton zoomInButton = findViewById(R.id.button_zoom_in);
        zoomInButton.setOnClickListener(v -> {
            if (mMap != null) {
                float currentZoom = mMap.getCameraPosition().zoom;
                mMap.animateCamera(CameraUpdateFactory.zoomTo(currentZoom + 1)); // Zoom in
            }
        });

        // Set up zoom out button
        ImageButton zoomOutButton = findViewById(R.id.button_zoom_out);
        zoomOutButton.setOnClickListener(v -> {
            if (mMap != null) {
                float currentZoom = mMap.getCameraPosition().zoom;
                mMap.animateCamera(CameraUpdateFactory.zoomTo(currentZoom - 1)); // Zoom out
            }
        });

        // Set up directions button
        ImageButton directionsButton = findViewById(R.id.button_directions);
        directionsButton.setOnClickListener(v -> {
            String uri = String.format("google.navigation:q=%f,%f", companyLocation.latitude, companyLocation.longitude);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            intent.setPackage("com.google.android.apps.maps"); // Open in Google Maps
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                // Fallback to browser if Google Maps is not installed
                Uri browserUri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=" + companyLocation.latitude + "," + companyLocation.longitude);
                startActivity(new Intent(Intent.ACTION_VIEW, browserUri));
            }
        });
        // Obtain the SupportMapFragment and get notified when the map is ready
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.addMarker(new MarkerOptions().position(companyLocation).title("Ma and Pa Railroad"));

        // Enable user location if permission is granted
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        LatLng location = new LatLng(39.808225, -76.4736); // Replace with your desired location
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 17)); // Zoom level 10 (lower value = zoomed out)

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 17)); // Smooth zoom-out animation

        // Overlay the site image
        GroundOverlayOptions overlayOptions = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.tourmap3))
                .position(location, 500f, 400f)
                .transparency(0.4f); // Adjust size as needed
        mMap.addGroundOverlay(overlayOptions);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
            }
        }
    }
}