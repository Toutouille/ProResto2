package com.example.tmary.proresto2;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.util.Log;
import android.widget.ImageView;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Petermarzinou on 15/12/2015.
 */
public class Restaurant {

    public static int NbRestos = 4;

    private int id;
    private String idMaps;
    private int pageNum;
    private String name;
    private String description;
    private LatLng Position = new LatLng(49.184479, -0.359762); // Initialize to CAEN.
    private BitmapDescriptor colorIcon;
    private ImageView imageView;

    protected Context context;

    public Restaurant(Context context, int id) {
        this.context = context.getApplicationContext();
        this.id = id;
        switch(id) {
            case 1: // ENSICAEN
                idMaps = "m1";
                pageNum = 1;
                name = context.getResources().getString(R.string.title_ensicaen);
                description =  context.getResources().getString(R.string.snipet_ensicaen);
                Position = new LatLng(49.214281, -0.36759);
                colorIcon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE);
                break;

            case 2: // DOLLYS
                idMaps = "m2";
                pageNum = 2;
                name = context.getResources().getString(R.string.title_resto_dollys);
                description = context.getResources().getString(R.string.snipet_resto_dollys);
                Position = new LatLng(49.184479, -0.359762);
                colorIcon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN);
                break;

            case 3: // RUA
                idMaps = "m3";
                pageNum = 3;
                name = context.getResources().getString(R.string.title_resto_rua);
                description = context.getResources().getString(R.string.snipet_resto_rua);
                Position = new LatLng(49.213195, -0.366050);
                colorIcon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE);
                break;

            case 4: // BURGER
                idMaps = "m4";
                pageNum = 4;
                name = context.getResources().getString(R.string.title_resto_atelier_burger);
                description = context.getResources().getString(R.string.snipet_resto_atelier_burger);
                Position = new LatLng(49.184814, -0.358933);
                colorIcon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN);
                break;
        }
        Log.v("Resto.java", "Switch OK");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPageNum() {
        return pageNum-1;   // Because the page begins to 0 within the RestoActivity
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BitmapDescriptor getColorIcon() {
        return colorIcon;
    }

    public LatLng getPosition() {
        return Position;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

}
