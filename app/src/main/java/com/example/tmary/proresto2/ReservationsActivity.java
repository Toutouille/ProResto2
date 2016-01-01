package com.example.tmary.proresto2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Tristan on 23/12/2015.
 */
public class ReservationsActivity extends Activity{

    public static final String PREFERENCES = "preferences";
    public static final String RESERVAION_SAVE = "saveKey";
    public static String str_resa = "";
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);

        // Open shared preferences editor
        preferences = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);

        // Try to get existing reservations
        String resa = preferences.getString(RESERVAION_SAVE, "NULL");
        Log.v("reservation", resa);

        // If there is no reservation
        if(resa.equals("NULL"))
        {
            str_resa = " Aucune réservations";
        }

        // If there is some existing reservations
        else
        {
            str_resa = resa;
        }

        // Print all resarvations in the editText
        TextView myTextView = (TextView) findViewById(R.id.id_text_all_reservations);
        myTextView.setText(str_resa);

    }

    public void onClickButtonClearReservations(View v){

        // Delete the String containing all the reservations data
        preferences = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(RESERVAION_SAVE);
        editor.apply();

        // Make a toast
        Toast.makeText(this, "Suppression effectuée", Toast.LENGTH_SHORT).show();

        // Restart the activity for refreshing the data displayed
        recreate();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reservations, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
