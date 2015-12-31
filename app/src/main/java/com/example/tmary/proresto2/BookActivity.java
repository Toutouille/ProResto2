package com.example.tmary.proresto2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * Created by tmary on 12/11/15.
 */
public class BookActivity extends Activity {

    Spinner spin_selected_resto;
    String selected_resto;
    String selected_date;
    String selected_time;
    String selected_nb_persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Intent intent = getIntent();
        int int_selected_resto = 1;
        int_selected_resto = intent.getIntExtra("int_selected_resto", 1);

        spin_selected_resto = (Spinner) findViewById((R.id.id_spinner_selected_resto));
        spin_selected_resto.setSelection(int_selected_resto);
        selected_resto = String.valueOf(spin_selected_resto.getSelectedItem());

        EditText editText_selected_date = (EditText)findViewById(R.id.id_editText_date);
        selected_date = editText_selected_date.getText().toString();
        EditText editText_selected_time = (EditText)findViewById(R.id.id_editText_time);
        selected_time = editText_selected_time.getText().toString();
        EditText editText_selected_nb_persons = (EditText)findViewById(R.id.id_editText_nb_persons);
        selected_nb_persons = editText_selected_nb_persons.getText().toString();


    }

    public void onClickButtonBook(View v){
        Log.v("onClickButtonBook", "OK");
        // TODO : Test des conditions pour la réservation
        // TODO : Résourdre le problème de sauvegarde des données

        // Concatenate the data of the reservation into one single string
        String string_resa = selected_resto + "#" + selected_date + "#" + selected_time +"#" + selected_nb_persons + ".";

        // Open shared preferences editor
        SharedPreferences preferences = this.getSharedPreferences("com.example.tmary.proresto2", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        // Search if there is already some existing reservations
        String resa = preferences.getString("RESERVAION_SAVE", "NULL");

        // If it does, concatenate the existing string with the new one.
        if(resa != "NULL")
        {
            resa = resa + string_resa;
        }

        // If not create a new string conaining only the new reservation
        else
        {
            resa = string_resa;
        }

        // Commit change
        editor.clear();
        editor.putString("RESERVAION_SAVE", resa);
        editor.commit();

        // Make a toast for the good saving of the data
        Toast.makeText(this, "Réservation effectuée", Toast.LENGTH_SHORT).show();

        // Switch to My reservations activity
        Intent intent = new Intent(BookActivity.this, ReservationsActivity.class);
        startActivity(intent);
    }


    public void onClickButtonMyReservations(View view) {
        Log.v("onClickButtonRes", "OK");
        // Start ReservationActivity
        Intent intent = new Intent(BookActivity.this, ReservationsActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_order, menu);
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
