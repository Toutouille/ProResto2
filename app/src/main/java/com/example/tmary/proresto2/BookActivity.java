package com.example.tmary.proresto2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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

    public static final String PREFERENCES = "preferences";
    public static final String RESERVAION_SAVE = "saveKey";
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        // Get the selected restaurant in the list of restaurant
        Intent intent = getIntent();
        int int_selected_resto = 1;
        int_selected_resto = intent.getIntExtra("int_selected_resto", 1);
        Log.v("selected resto", String.valueOf(int_selected_resto));

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

        // Get the values of all parameters for the reservation
        EditText editText_selected_date = (EditText)findViewById(R.id.id_editText_date);
        EditText editText_selected_time = (EditText)findViewById(R.id.id_editText_time);
        EditText editText_selected_nb_persons = (EditText)findViewById(R.id.id_editText_nb_persons);
        selected_resto = String.valueOf(spin_selected_resto.getSelectedItem());
        selected_date = editText_selected_date.getText().toString();
        selected_time = editText_selected_time.getText().toString();
        selected_nb_persons = editText_selected_nb_persons.getText().toString();

        // Test if those parameters are correct
        int test = reservationTest(selected_resto, selected_date, selected_time, selected_nb_persons);

        // If it is
        if(test == 1)
        {
            // Concatenate the data of the reservation into one single string
            String string_resa = selected_resto + " le " + selected_date + " à " + selected_time +" pour " + selected_nb_persons + " personnes\n\n";

            // Open shared preferences editor
            preferences = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();

            // Search if there is already some existing reservations
            String resa = preferences.getString(RESERVAION_SAVE, "NULL");

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
            editor.remove(RESERVAION_SAVE);
            editor.putString(RESERVAION_SAVE, resa);
            editor.commit();
            Log.v("commmit", resa);

            // Make a toast for the good saving of the data
            Toast.makeText(this, "Réservation effectuée", Toast.LENGTH_SHORT).show();

            // Switch to My reservations activity
            Intent intent = new Intent(BookActivity.this, ReservationsActivity.class);
            startActivity(intent);
        }

    }


    public void onClickButtonMyReservations(View view) {
        // Start ReservationActivity
        Intent intent = new Intent(BookActivity.this, ReservationsActivity.class);
        startActivity(intent);
    }

    public int reservationTest(String resto, String date, String time, String nbpersons)
    {
        // No restaurant selected
        if(resto.equals(""))
        {
            Toast.makeText(this, "Veuillez sélectionner un restaurant", Toast.LENGTH_SHORT).show();
            return 0;
        }
        // No date selected
        if(date.equals(""))
        {
            Toast.makeText(this, "Veuillez sélectionner une date", Toast.LENGTH_SHORT).show();
            return 0;
        }
        // No time selected
        if(time.equals(""))
        {
            Toast.makeText(this, "Veuillez sélectionner un horaire", Toast.LENGTH_SHORT).show();
            return 0;
        }
        // No number of persons selected

        if(nbpersons.equals("") || Integer.parseInt(nbpersons) == 0)
        {
            Toast.makeText(this, "Veuillez sélectionner un nombre de personnes", Toast.LENGTH_SHORT).show();
            return 0;
        }
        // Wrong pattern of date
        String pattern = "^(((0[1-9])|([1-2][0-9])|(3[0-1]))/((0[1-9])|(1[0-2]))/[0-9]{4})$";
        if(!date.matches(pattern))
        {
            Toast.makeText(this, "Format de date incorrect. Utiliser dd/mm/yyyy", Toast.LENGTH_SHORT).show();
            return 0;
        }
        // Wrong pattern of time
        pattern = "^((([0-1][0-9])|(2[0-3])):([0-5][0-9]))$";
        if(!time.matches(pattern))
        {
            Toast.makeText(this, "Format d'horaire incorrect. Utiliser hh:mm", Toast.LENGTH_SHORT).show();
            return 0;
        }

        return 1;
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
        if(id == R.id.action_settings)
        {
            Toast.makeText(this, "Non implémenté", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
