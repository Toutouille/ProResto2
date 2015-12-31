package com.example.tmary.proresto2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Tristan on 23/12/2015.
 */
public class ReservationsActivity extends Activity{

    public String RESERVATION_SAVE;
    public String str_resa = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);

        // Open shared preferences editor
        SharedPreferences preferences = this.getSharedPreferences("com.example.tmary.proresto2", Context.MODE_PRIVATE );

        // Try to get existing reservations
        RESERVATION_SAVE = preferences.getString("RESERVAION_SAVE", "NULL");

        // If there is no reservation
        if(RESERVATION_SAVE == "NULL")
        {
            str_resa = " No reservations";
        }

        else
        {
            String[] string_resa_splited = RESERVATION_SAVE.split(".");
            for(int i=0; i<string_resa_splited.length; i++)
            {
                String[] string_resa_splited_twice = string_resa_splited[i].split("#");
                str_resa = str_resa + string_resa_splited_twice[0] + " the " + string_resa_splited_twice[1] + " at " + string_resa_splited_twice[2] + " for " + string_resa_splited_twice[3] + " persons\n";
            }
        }
        TextView myTextView = (TextView) findViewById(R.id.id_text_all_reservations);
        myTextView.setText(str_resa);

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
