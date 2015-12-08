package com.example.tmary.proresto2;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity
        implements
        GoogleMap.OnMyLocationButtonClickListener,
        OnMapReadyCallback,
        GoogleMap.OnInfoWindowClickListener {

    static final LatLng CAEN = new LatLng(49.183, -0.3715);
    static final LatLng ENSICAEN = new LatLng(49.214281, -0.36759);

    // All restaurants' marker here
    static final LatLng HAMBURGER = new LatLng(49.184814, -0.358933);
    static final LatLng DOLLY = new LatLng(49.184479, -0.359762);
    static final LatLng RUA = new LatLng(49.213195, -0.366050);

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
        // Activation of the WindowListener
        googleMap.setOnInfoWindowClickListener(this);
        // Add a marker in Caen and ENSICAEN
        Marker ENSICAEN_marker = mMap.addMarker(new MarkerOptions()
                .position(ENSICAEN)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .title("Ecole Nationale D'ingénieur de Caen")
                .snippet("Pas si mal que ça..!"));



        // move the camera to caen
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CAEN));

        // Zoom (level 14) to Caen
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14), 2000, null);

        // Restaurants Markers
        Marker DOLLY_marker = mMap.addMarker(new MarkerOptions()
                .position(DOLLY)
                .title(getString(R.string.title_resto_dollys))
                .snippet(getString(R.string.snipet_resto_dollys))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        Marker RUA_marker = mMap.addMarker(new MarkerOptions()
                .position(RUA)
                .title(getString(R.string.title_resto_rua))
                .snippet(getString(R.string.snipet_resto_rua))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        Marker HAMBURGER_marker = mMap.addMarker(new MarkerOptions()
                .position(HAMBURGER)
                .title(getString(R.string.title_resto_atelier_burger))
                .snippet(getString(R.string.snipet_resto_atelier_burger))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        // Caen city Marker (the last one)
        Marker CAEN_marker = mMap.addMarker(new MarkerOptions()
                .position(CAEN)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

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


    @Override
    public void onInfoWindowClick(Marker clicked_marker) {
        Toast.makeText(this, "Restaurant " + clicked_marker.getTitle() + " selected ", Toast.LENGTH_SHORT).show();
        //On créé un objet Bundle, c'est ce qui va nous permetre d'envoyer des données à l'autre Activity
        Bundle objetbunble = new Bundle();
        //Cela fonctionne plus ou moins comme une HashMap, on entre une clef et sa valeur en face
        objetbunble.putString("resto_choisi", clicked_marker.getId());
        Intent intent = new Intent(MapsActivity.this, RestoActivity.class);
        //On affecte à l'Intent le Bundle que l'on a créé
        intent.putExtras(objetbunble);

        startActivity(intent);
        //TODO: When the info windows is clicked, select the restaurant and propose more information to view. May be from the database

    }



}
