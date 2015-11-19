package com.example.tmary.proresto2;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity
        implements
        GoogleMap.OnMyLocationButtonClickListener,
        OnMapReadyCallback {

    static final LatLng CAEN = new LatLng(49.183, -0.3715);

    // All restaurants' marker here
    static final LatLng HAMBURGER = new LatLng(49.184814, -0.358933);
    static final LatLng DOLLY = new LatLng(49.184479, -0.359762);

    private GoogleMap mMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Caen and move the camera
        mMap.addMarker(new MarkerOptions().position(CAEN));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CAEN));

        // Zoom (level 14) to Caen
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14), 2000, null);

        // Add some restaurants
        if (mMap != null) {
            Marker Atelier_du_burger = mMap.addMarker(new MarkerOptions().position(HAMBURGER)
                    .title("L'atelier du burger"));
            Marker Dolly_s = mMap.addMarker(new MarkerOptions()
                    .position(DOLLY)
                    .title("Dolly's")
                    .snippet("Dolly's is cool"));
            //.icon(BitmapDescriptorFactory.fromResource(R.drawable.)));
        }

        // Activate geolocalisation
        mMap.setOnMyLocationButtonClickListener(this);
        enableMyLocation();
    }


    /**
     * Enables the My Location layer
     */
    private void enableMyLocation() {
        if (mMap != null) {

            mMap.setMyLocationEnabled(true);
        }
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "Retour sur votre position...", Toast.LENGTH_SHORT).show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }


}
