package com.example.tmary.proresto2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final LinearLayout LayoutBookClick = (LinearLayout) findViewById(R.id.LayoutBook);
        final LinearLayout LayoutOrderClick = (LinearLayout) findViewById(R.id.LayoutOrder);
        final LinearLayout LayoutMapClick = (LinearLayout) findViewById(R.id.LayoutMap);
        final LinearLayout LayoutProfileClick = (LinearLayout) findViewById(R.id.LayoutProfile);

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
                Intent intent = new Intent(Home.this, MapActivity.class);
                startActivity(intent);
            }
        });

        LayoutProfileClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // START PROFILE ACTIVITY
                Intent intent = new Intent(Home.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
