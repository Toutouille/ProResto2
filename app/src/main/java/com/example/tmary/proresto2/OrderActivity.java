package com.example.tmary.proresto2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by tmary on 12/11/15.
 */
public class OrderActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Button order_button = (Button)findViewById(R.id.id_button_order);
        final EditText text_filed_date   = (EditText)findViewById(R.id.editText_date);
        final EditText text_filed_time   = (EditText)findViewById(R.id.editText_time);
        final EditText text_filed_nb_persons   = (EditText)findViewById(R.id.editText_nb_persons);

        order_button.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Réservation effectuée",Toast.LENGTH_SHORT).show();
                    }
                });
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

    final Spinner spin_selected_resto = (Spinner) findViewById((R.id.id_spinner_selected_resto));
    //final Spinner spin_selected_date = (Spinner) findViewById((R.id.id_spinner_selected_date));
    //final Spinner spin_selected_time = (Spinner) findViewById((R.id.id_spinner_selected_time));
    //final Spinner spin_selected_nb_persons = (Spinner) findViewById((R.id.id_spinner_selected_nb_persons));

    final String selected_resto = String.valueOf(spin_selected_resto.getSelectedItem());
    //final String selected_date = String.valueOf(spin_selected_date.getSelectedItem());
    //final String selected_time = String.valueOf(spin_selected_time.getSelectedItem());
    //final String selected_nb_persons = String.valueOf(spin_selected_nb_persons.getSelectedItem());

}
