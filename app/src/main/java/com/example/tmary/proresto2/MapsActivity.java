package com.example.tmary.proresto2;


import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
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

    // Indique le nombre de restaurants enregistrés.
    int nbRestos = Restaurant.NbRestos;
    Restaurant Resto;
    Marker tab_markers[] = new Marker[Restaurant.NbRestos+1];
    static final LatLng CAEN = new LatLng(49.183, -0.3715);

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

        // move the camera to caen
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CAEN));

        // Zoom (level 14) to Caen
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14), 2000, null);

        // Caen city Marker (the first one)
        Marker CAEN_marker = mMap.addMarker(new MarkerOptions()
                .position(CAEN)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        // Restaurants Markers
        for (int i=1; i<=nbRestos; i++){
            Resto = new Restaurant(this.getApplicationContext(), i, true);
            tab_markers[i] = mMap.addMarker(new MarkerOptions()
                    .position(Resto.getPosition())
                    .title(Resto.getName())
                    .snippet(Resto.getSnipet())
                    .icon(Resto.getColorIcon()));
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


    @Override
    public void onInfoWindowClick(Marker clicked_marker) {
        Toast.makeText(this, "Restaurant " + clicked_marker.getTitle() + " selected ", Toast.LENGTH_SHORT).show();
        //On créé un objet Bundle, c'est ce qui va nous permetre d'envoyer des données à l'autre Activity
        Bundle objetbunble = new Bundle();
        //Cela fonctionne plus ou moins comme une HashMap, on entre une clef et sa valeur en face
        objetbunble.putString("id_resto_choisi", clicked_marker.getId());
        Intent intent = new Intent(MapsActivity.this, RestoActivity.class);
        //On affecte à l'Intent le Bundle que l'on a créé
        intent.putExtras(objetbunble);

        startActivity(intent);
    }
}
