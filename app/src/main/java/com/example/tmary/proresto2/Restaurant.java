package com.example.tmary.proresto2;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Petermarzinou on 15/12/2015.
 */
public class Restaurant {

    // Indique le nombre de restaurants dans la base de données
    public static int NbRestos = 10;

    private int id;
    private String idMaps;
    private int pageNum;
    private String name;
    private String description;
    private String snipet;
    private LatLng Position = new LatLng(49.184479, -0.359762); // Initialize to CAEN.
    private BitmapDescriptor colorIcon;
    private ImageView imageView;
    private Schedule MySchedule;


    protected Context context;

    public Restaurant(Context context, int id, boolean mapsActivity) {
        this.context = context.getApplicationContext();
        this.id = id;
        switch(id) {
            case 1: // ENSICAEN
                idMaps = "m1";
                pageNum = 1;
                name = context.getResources().getString(R.string.title_ensicaen);
                description = context.getResources().getString(R.string.description_ensicaen);
                if (mapsActivity){
                    snipet =  context.getResources().getString(R.string.snipet_ensicaen);
                    Position = new LatLng(49.214281, -0.36759);
                    colorIcon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE);
                }
                MySchedule = new Schedule();
                break;

            case 2: // DOLLYS
                idMaps = "m2";
                pageNum = 2;
                name = context.getResources().getStringArray(R.array.array_resto_dollys)[0];
                description = context.getResources().getStringArray(R.array.array_resto_dollys)[1];
                if (mapsActivity){
                    snipet = context.getResources().getStringArray(R.array.array_resto_dollys)[2];
                    Position = new LatLng(49.184479, -0.359762);
                    colorIcon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN);
                }
                MySchedule = new Schedule("11h - 18h", "10h00 - 19h", "10h00 - 22h30","10h00 - 22h30","10h00 - 22h30","10h00 - 22h30","10h00 - 22h30");
                break;

            case 3: // RUA
                idMaps = "m3";
                pageNum = 3;
                name = context.getResources().getStringArray(R.array.array_resto_rua)[0];
                description = context.getResources().getStringArray(R.array.array_resto_rua)[1];
                if (mapsActivity) {
                    snipet = context.getResources().getStringArray(R.array.array_resto_rua)[2];
                    Position = new LatLng(49.213195, -0.366050);
                    colorIcon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE);
                }
                MySchedule = new Schedule("11h30 - 13h30\t18h30 - 20h" ,"11h30 - 13h30\t18h30 - 20h" ,"11h30 - 13h30\t18h30 - 20h" ,"11h30 - 13h30\t18h30 - 20h" ,"11h30 - 13h30" ,"Fermé", "Fermé");
                break;

            case 4: // Atelier du Burger
                idMaps = "m4";
                pageNum = 4;
                name = context.getResources().getStringArray(R.array.array_resto_atelier_burger)[0];
                description = context.getResources().getStringArray(R.array.array_resto_atelier_burger)[1];
                if (mapsActivity){
                    snipet = context.getResources().getStringArray(R.array.array_resto_atelier_burger)[2];
                    Position = new LatLng(49.184814, -0.358933);
                    colorIcon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN);
                }
                MySchedule = new Schedule("12h00 - 14h30\t19h - 11h30");
                break;

            case 5: // A contre sens
                idMaps = "m5";
                pageNum = 5;
                name = context.getResources().getStringArray(R.array.array_resto_a_contre_sens)[0];
                description = context.getResources().getStringArray(R.array.array_resto_a_contre_sens)[1];
                if (mapsActivity) {
                    snipet = context.getResources().getStringArray(R.array.array_resto_a_contre_sens)[2];
                    Position = new LatLng(49.184412, -0.365658);
                    colorIcon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN);
                }
                MySchedule = new Schedule("Fermé" , "19h30 - 21h15", "12h00 - 13h15\t19h30 - 21h15", "12h00 - 13h15\t19h30 - 21h15", "12h00 - 13h15\t19h30 - 21h15", "12h00 - 13h15\t19h30 - 21h15", "Fermé");
                break;

            case 6: // Le bistrot 102
                idMaps = "m6";
                name = context.getResources().getStringArray(R.array.array_resto_le_bistrot_102)[0];
                description = context.getResources().getStringArray(R.array.array_resto_le_bistrot_102)[1];
                if (mapsActivity) {
                    snipet = context.getResources().getStringArray(R.array.array_resto_le_bistrot_102)[2];
                    Position = new LatLng(49.182644, -0.373646);
                    colorIcon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN);
                }
                MySchedule = new Schedule("Fermé" , "12h - 14h\t19h30 - 22h", "12h - 14h\t19h30 - 22h","12h - 14h\t19h30 - 22h","12h - 14h\t19h30 - 22h", "19h30 - 22h", "Fermé");
                break;

            case 7: // La Cave à Huitres
                idMaps = "m7";
                pageNum = 7;
                name = context.getResources().getStringArray(R.array.array_resto_cave_a_huitres)[0];
                description = context.getResources().getStringArray(R.array.array_resto_cave_a_huitres)[1];
                if (mapsActivity) {
                    snipet = context.getResources().getStringArray(R.array.array_resto_cave_a_huitres)[2];
                    Position = new LatLng(49.181863, -0.3558396);
                    colorIcon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN);
                }
                MySchedule = new Schedule("11h - 15h\t18h30 - 23h", 1);
                break;

            case 8: // Anouche
                idMaps = "m8";
                pageNum = 8;
                name = context.getResources().getStringArray(R.array.array_resto_anouche)[0];
                description = context.getResources().getStringArray(R.array.array_resto_anouche)[1];
                if (mapsActivity) {
                    snipet = context.getResources().getStringArray(R.array.array_resto_anouche)[2];
                    Position = new LatLng(49.184757, -0.356112);
                    colorIcon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN);
                }
                MySchedule = new Schedule("12h - 14h\t19h - 21h", "12h - 14h\t19h - 21h", "12h - 14h\t19h - 21h", "12h - 14h\t19h - 21h", "12h - 14h\t19h - 21h", "19h - 21h", "12h - 14h");
                break;

            case 9: // Burger Street
                idMaps = "m9";
                pageNum = 9;
                name = context.getResources().getStringArray(R.array.array_resto_burger_street)[0];
                description = context.getResources().getStringArray(R.array.array_resto_burger_street)[1];
                if (mapsActivity) {
                    snipet = context.getResources().getStringArray(R.array.array_resto_burger_street)[2];
                    Position = new LatLng(49.182114, -0.367673);
                    colorIcon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN);
                }
                MySchedule = new Schedule("Fermé" , "12h - 23h", "12h - 23h", "12h - 23h", "12h - 23h", "12h - 23h", "Fermé");
                break;

            case 10: // le sans gene
                idMaps = "m10";
                pageNum = 10;
                name = context.getResources().getStringArray(R.array.array_resto_le_sans_gene)[0];
                description = context.getResources().getStringArray(R.array.array_resto_le_sans_gene)[1];
                if (mapsActivity) {
                    snipet = context.getResources().getStringArray(R.array.array_resto_le_sans_gene)[2];
                    Position = new LatLng(49.185341, -0.359256);
                    colorIcon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN);
                }
                MySchedule = new Schedule("19h - 23h30", 1);
                break;

            /*case xx: // nouveau resto
                idMaps = "mxx";
                pageNum = xx;
                name = context.getResources().getStringArray(R.array.array_resto_)[0];
                description = context.getResources().getStringArray(R.array.array_resto_)[1];
                snipet = context.getResources().getStringArray(R.array.array_resto_)[2];
                Position = new LatLng(x , y);
                colorIcon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN);
                MySchedule = new Schedule();
                break;*/

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

    public String getSnipet() {
        return snipet;
    }

    public BitmapDescriptor getColorIcon() {
        return colorIcon;
    }

    public LatLng getPosition() {
        return Position;
    }

    public ImageView getImageView(ImageView imageView, int pageSelected) {
        switch(pageSelected) {
            case 2:
                imageView.setImageResource(R.drawable.logo_dollys);
                break;
            case 3:
                imageView.setImageResource(R.drawable.logo_rua);
                break;
            case 4:
                imageView.setImageResource(R.drawable.logo_atelier_du_burger);
                break;
            case 5:
                imageView.setImageResource(R.drawable.logo_a_contre_sens);
                break;
            case 6:
                imageView.setImageResource(R.drawable.logo_le_bistrot_102);
                break;
            case 7:
                imageView.setImageResource(R.drawable.logo_la_cave_a_huitres);
                break;
            case 8:
                imageView.setImageResource(R.drawable.logo_anouche);
                break;
            case 9:
                imageView.setImageResource(R.drawable.logo_burger_street);
                break;
            case 10:
                imageView.setImageResource(R.drawable.logo_le_sans_gene);
                break;
        }
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Schedule getMySchedule() {
        return MySchedule;
    }

}
