package com.example.tmary.proresto2;

import android.app.Activity;
import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Intent intent = getIntent();
        String resto_choisi_liste = intent.getStringExtra(RestoActivity.Extra_message);

        spin_selected_resto = (Spinner) findViewById((R.id.id_spinner_selected_resto));
        //TODO : Résoudre le passage des arguments pour sélectionner le bon resto.
        //if(resto_choisi_liste.equals("m2")) spin_selected_resto.setSelection(2);
        //if(resto_choisi_liste.equals("m3")) spin_selected_resto.setSelection(3);
        //if(resto_choisi_liste.equals("m4")) spin_selected_resto.setSelection(4);
        //if(resto_choisi_liste.equals("m5")) spin_selected_resto.setSelection(5);
        //if(resto_choisi_liste.equals("m6")) spin_selected_resto.setSelection(6);
        //if(resto_choisi_liste.equals("m7")) spin_selected_resto.setSelection(7);
        //if(resto_choisi_liste.equals("m8")) spin_selected_resto.setSelection(8);
        //if(resto_choisi_liste.equals("m9")) spin_selected_resto.setSelection(9);
       // if(resto_choisi_liste.equals("m10")) spin_selected_resto.setSelection(10);

        selected_resto = String.valueOf(spin_selected_resto.getSelectedItem());

        EditText editText_selected_date = (EditText)findViewById(R.id.id_editText_date);
        String selected_date = editText_selected_date.getText().toString();
        EditText editText_selected_time = (EditText)findViewById(R.id.id_editText_time);
        String selected_time = editText_selected_time.getText().toString();
        EditText editText_selected_nb_persons = (EditText)findViewById(R.id.id_editText_nb_persons);
        String selected_nb_persons = editText_selected_nb_persons.getText().toString();


    }

    public void onClickButtonBook(View v){
        Log.v("onClickButtonBook", "OK");
        // TODO : Test des conditions pour la réservation

        Toast.makeText(this, "Réservation effectuée", Toast.LENGTH_SHORT).show();
        // Switch vers l'activité My reservations après avoir effectué une réservation
        Intent intent = new Intent(BookActivity.this, ReservationsActivity.class);
        startActivity(intent);
    }
    public void onClickButtonMyReservations(View view) {
        Log.v("onClickButtonRes", "OK");
        // Start BookActivity for the selected restaurant
        Intent intent = new Intent(BookActivity.this, ReservationsActivity.class);
        //On créer un objet Bundle, c'est ce qui va nous permettre d'envoyer des données à l'autre Activity
        //Bundle objetbunble = new Bundle();
        //objetbunble.putInt("id_resto_choisi", id_resto_choisi_int);
        //On affecte à l'Intent le Bundle que l'on a créé
        //intent.putExtras(objetbunble);
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
