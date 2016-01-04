package com.example.tmary.proresto2;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final LinearLayout LayoutBookClick = (LinearLayout) findViewById(R.id.LayoutBook);
        final LinearLayout LayoutOrderClick = (LinearLayout) findViewById(R.id.LayoutOrder);
        final LinearLayout LayoutMapClick = (LinearLayout) findViewById(R.id.LayoutMap);
        final LinearLayout LayoutProfileClick = (LinearLayout) findViewById(R.id.LayoutResto);
        final LinearLayout LayoutRestoClick = (LinearLayout) findViewById(R.id.LayoutResto);
        final LinearLayout LayoutSettingsClick = (LinearLayout) findViewById(R.id.action_settings);

        LayoutBookClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // START BOOK ACTIVITY
                Intent intent = new Intent(Home.this, BookActivity.class);
                startActivity(intent);
            }
        });

        LayoutOrderClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // START ORDER ACTIVITY
                Intent intent = new Intent(Home.this, OrderActivity.class);
                startActivity(intent);
            }
        });

        LayoutMapClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // START MAP ACTIVITY
                Intent intent = new Intent(Home.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        LayoutProfileClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // START PROFILE ACTIVITY
                Intent intent = new Intent(Home.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        LayoutRestoClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // START RESTO ACTIVITY
                Intent intent = new Intent(Home.this, RestoActivity.class);
                startActivity(intent);
            }
        });

        //TODO: Solve the calling of the settings activity
        /*LayoutSettingsClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // START SETTINGS ACTIVITY
                Intent intent = new Intent(Home.this, SettingsActivity.class);
                startActivity(intent);
            }
        });*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
