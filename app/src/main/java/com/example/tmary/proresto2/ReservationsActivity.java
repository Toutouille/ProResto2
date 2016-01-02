package com.example.tmary.proresto2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


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

        // Get reservations
        preferences = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
        String resa = preferences.getString(RESERVAION_SAVE, "NULL");
        Log.v("resa", resa);

        // If there is none
        if(resa.equals("NULL"))
        {
            Toast.makeText(this, "Aucune réservation à annuler", Toast.LENGTH_SHORT).show();
        }

        // If there is some
        else
        {
            // Split the string of all the reservations into multiple string containing each one reservation
            final String[] parts = resa.split("\\n\\n");

            // This contain the actual reservations
            CharSequence[] list_reservations = new CharSequence[parts.length];
            for(int i=0; i<parts.length; i++)
            {
                list_reservations[i] = parts[i];
            }

            // this array will contain the selected item
            final ArrayList mSelectedItems = new ArrayList();

            // Create à dialog for selected reservations to cancel
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Annuler des réservations");
            builder.setMultiChoiceItems(list_reservations, null, new DialogInterface.OnMultiChoiceClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which,
                                    boolean isChecked) {
                    if (isChecked) {
                        // If the user checked the item, add it to the selected items
                        mSelectedItems.add(which);
                    } else if (mSelectedItems.contains(which)) {
                        // Else, if the item is already in the array, remove it
                        mSelectedItems.remove(Integer.valueOf(which));
                    }
                }

            });

            // Set a button for cancel reservations
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // Delete the selected items

                    // Recreate the string without the part the user delete
                    String resa_final = "";
                    Object[] mStringArray = mSelectedItems.toArray();
                    int mStringArray_length = mStringArray.length;
                    int ok;
                    for (int i = 0; i < parts.length; i++) {
                        ok = 1;

                        for (int j = 0; j < mStringArray_length; j++) {
                            if (i == (int) mStringArray[j]) {
                                ok = 0;
                            }
                        }

                        if (ok == 1) {
                            resa_final = resa_final + parts[i] + "\n\n";
                        }
                    }

                    // If there is some reservations left

                    // Delete the String containing all the reservations data
                    preferences = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.remove(RESERVAION_SAVE);
                    if (!resa_final.equals(""))
                    {
                        editor.putString(RESERVAION_SAVE, resa_final);
                    }
                    editor.apply();

                    // Restart the activity for refreshing the data displayed
                    recreate();
                }
            });

            // Set a button for go back
            builder.setNegativeButton("Retour", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // Do nothing exepct close the dialog, which is done automatically
                }
            });


            // Create and show this dialog
            builder.create();
            builder.show();
        }

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
